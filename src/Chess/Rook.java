package Chess;

public class Rook extends Piece{
    public Rook(int x, int y, Side side) {
        super(x, y, side);
    }

    @Override
    public boolean canMove(int x, int y, boolean isKilling) {
        //Check linear:
        return (this.x == x || this.y == y);
    }
}
