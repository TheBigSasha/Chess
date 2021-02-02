package Chess;

public class Queen extends Piece{
    public Queen(int x, int y, Side side) {
        super(x, y, side);
    }

    @Override
    public boolean canMove(int x, int y, boolean isKilling) {
        //Check diagonal:
        int diffX = this.x - x;
        int diffY = this.y - y;
        if(diffX == diffY) return true;

        //Check linear:
        if(this.x == x || this.y == y) return true;

        //Check 1 diff:
        return (Math.abs(this.x - x) <= 1 && Math.abs(this.y) - y <=1);
    }
}
