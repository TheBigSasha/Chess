package Chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Sorry, chess nerds. No castling and pawns do not promote on the other side.
 */
public class GameApp {
    static Game g;
    static ChessEngine canvas;
    private static TextField oriX = new TextField();
    private static TextField oriY = new TextField();
    private static TextField desX = new TextField();
    private static TextField desY = new TextField();



    public static void main(String[] args){
        g = new Game();
        JFrame frame = new JFrame(Game.getName());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored){ }


        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        controls.add(new Label("Origin X: "));
        controls.add(oriX);
        controls.add(new Label("Origin Y: "));
        controls.add(oriY);
        controls.add(new Label("Dest X: "));
        controls.add(desX);
        controls.add(new Label("Dest Y: "));
        controls.add(desY);
        JButton peek = new JButton("Peek");
        JButton play = new JButton("Play");

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.move(Integer.parseInt(oriX.getText()), Integer.parseInt(oriY.getText()), Integer.parseInt(desX.getText()),Integer.parseInt(desY.getText()));
                canvas.repaint();
            }
        });
        controls.add(play);
        canvas = new ChessEngine(g.b);
        canvas.setSize(640, 640);

        frame.add(canvas, BorderLayout.CENTER);
        frame.add(controls, BorderLayout.SOUTH);
        peek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.setActivePiece(Integer.parseInt(oriX.getText()), Integer.parseInt(oriY.getText()));
                canvas.repaint();
            }
        });
        controls.add(peek);
        frame.setSize(600,600);
        frame.setVisible(true);
    }


}

/**
 * Unreal Engine? Who's she?
 */
class ChessEngine extends Canvas {
    //TODO: Implement real time ray tracing


    private final Board board;
    private Piece activePiece = null;

    public void setActivePiece(int x, int y){
        activePiece = board.get(x,y);
    }

    public ChessEngine(Board board) {
        this.board = board;
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {

        g.clearRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        int pxPerHor = getWidth() / 8;
        for (int i = 0; i < 8; i++) {
            int lenAtIdx = 8;
            int pxPerVer = getHeight() / lenAtIdx;
            for (int j = 0; j < 8; j++) {
                Color c = i  % 2 == j % 2 ? Color.LIGHT_GRAY : Color.DARK_GRAY;
                g.setColor(c);
                g.fillRect(i * pxPerHor, j * pxPerVer,pxPerHor, pxPerVer);
                if(activePiece != null){
                    if(board.canMove(activePiece.x, activePiece.y, i,j)){
                        c = i  % 2 == j % 2 ? Color.GREEN.darker() : Color.GREEN.darker().darker();
                        g.setColor(c);
                        g.fillRect(i * pxPerHor, j * pxPerVer,pxPerHor, pxPerVer);

                    }
                }

                if(board.get(i,j) != null){
                    Color d = board.get(i,j).getSide() == Piece.Side.WHITE? Color.WHITE : Color.BLACK;
                    g.setColor(d);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, Math.min(pxPerHor, pxPerVer)));
                    g.drawString(board.get(i,j).getSymbol(),i * pxPerHor, j * pxPerVer + pxPerVer);
                }


            }
        }
    }
}