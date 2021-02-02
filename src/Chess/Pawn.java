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
    public void move(int x, int y) {
        if(promotedTo != null){
            promotedTo.move(x,y);
        }else{
            //enforce rules
        }
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }
}
