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
        int acceptableDifferenceY = this.getSide().equals(Side.BLACK) ? 1 : -1;
        int requiredDifferenceX = isKilling ? 1 : 0;
        if(!hasMoved()){
            acceptableDifferenceY *=2;
        }

        if(Math.abs(this.x - x) != requiredDifferenceX){
            return false;
        }

        int diffX = Math.abs(this.x - x);


            if (acceptableDifferenceY > 0) {
                return y - this.y <= acceptableDifferenceY && y > this.y;
            } else {
                return y - this.y >= acceptableDifferenceY && y < this.y;
            }
            //TODO: fix this to account for direction (don't abs y) and for not being dumb
    }

    @Override
    public String getSymbol() {
        return this.getSide() == Side.BLACK ? "♟︎" : "♙";
    }
}
