import Chess.Piece;

public class King extends Piece {

    public King(int x, int y, Side side) {
        super(x, y, side);
    }

    @Override
    public void move(int x, int y) {
        if(canMove(x,y)){
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public boolean canMove(int x, int y) {
        return (Math.abs(this.x - x) <= 1 && Math.abs(this.y) - y <=1);
    }
}
