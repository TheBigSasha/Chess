package Chess;

public class Pawn extends Piece{
    private boolean hasMoved;
    public Pawn(int x, int y, Side side) {
        super(x, y, side);
        hasMoved = false;
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);
        hasMoved = true;
    }

    @Override
    public boolean canMove(int x, int y, boolean isKilling) {
        int acceptableDifferenceY = this.getSide().equals(Side.BLACK) ? 1 : -1;
        int requiredDifferenceX = isKilling ? 1 : 0;
        if(!hasMoved){
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
