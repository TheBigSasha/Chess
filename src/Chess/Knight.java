package Chess;

public class Knight extends Piece{
    public Knight(int x, int y, Side side) {
        super(x, y, side);
    }

    @Override
    public boolean canHop() {
        return true;
    }

    @Override
    public boolean canMove(int x, int y, boolean isKilling) {
        //L shaped move
        int deltaX = Math.abs(this.x - x);
        int deltaY = Math.abs(this.y - y);
        return deltaX + deltaY == 3 && deltaX > 0 && deltaY > 0;
    }
}