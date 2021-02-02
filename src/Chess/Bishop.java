package Chess;

public class Bishop extends Piece {
    public Bishop(int x, int y, Side side) {
        super(x, y, side);
    }

    @Override
    public boolean canMove(int x, int y, boolean isKilling) {
        //Check being on the diagonal
        int diffX = this.x - x;
        int diffY = this.y - y;
        return diffX == diffY;
    }
}
