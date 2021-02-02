package Chess;

public class Pawn extends Piece{
    private Piece promotedTo = null;

    public Pawn(int x, int y, Side side) {
        super(x, y, side);
    }

    public void promote(Piece promotedTo) {
        if((getSide().equals(Side.BLACK) && y == 0) || (getSide().equals(Side.WHITE) && y == 15)){
            promotedTo.setSide(this.getSide());
            promotedTo.x = this.x;
            promotedTo.y = this.y;
            this.promotedTo = promotedTo;
        }

    }

    @Override
    public boolean canMove(int x, int y, boolean isKilling) {
        int acceptableDifferenceY = this.getSide().equals(Side.BLACK) ? -1 : 1;
        int acceptableDifferenceX = isKilling ? 0 : 1;
        if(!hasMoved()){
            acceptableDifferenceY *=2;
        }
        return this.y - y == acceptableDifferenceY && Math.abs(this.x - x) == acceptableDifferenceX;
    }
}
