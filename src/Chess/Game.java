package Chess;

public class Game {
    Board b;
    Piece.Side lastMove;

    public Game(){
        b = new Board();
        lastMove = Piece.Side.BLACK;
    }

    public static String getName() {
        return "Queen's Game-bit";
    }

    public boolean move(int x, int y, int destX, int destY){
        //returns true if in check
        if(b.get(x,y).getSide() == lastMove){
            return false;
        }

        Piece toMove = b.get(x,y);
        b.move(x,y,destX,destY);

        lastMove = toMove.getSide();

        Piece.Side kingToKill = toMove.getSide() == Piece.Side.WHITE ? Piece.Side.BLACK : Piece.Side.WHITE;
        King toKill = b.getKing(kingToKill);
        for(Piece p : b.getPieces(toMove.getSide())){
            if(b.canMove(p.x, p.y, toKill.x, toKill.y)){
                return true;
            }
        }
        return false;
    }

    public void reset(){
        b.resetGame();
        lastMove = Piece.Side.BLACK;
    }


    public static void main(String[] args){
        Board b = new Board();
        System.out.println(b);
    }
}
