package  Chess;

public class King extends Piece {

    public King(int x, int y, Side side) {
        super(x, y, side);
    }

    @Override
    public boolean canMove(int x, int y, boolean isKilling) {
        return (Math.abs(this.x - x) <= 1 && Math.abs(this.y) - y <=1);
    }

    @Override
    public String getSymbol() {
        return this.getSide() == Side.BLACK ? "♚" : "♔";
    }
}
