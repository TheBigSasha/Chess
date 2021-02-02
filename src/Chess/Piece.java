package Chess;

public abstract class Piece {
    protected int x, y;     //Accessible within package and to subclasses

    private boolean isDead;


    private Side side;

    public Piece(int x, int y, Side side) {
        this.x = x;
        this.y = y;
        this.side = side;
        isDead = false;
    }

    public void resurrect(int x, int y){
        isDead = false;
        this.x = x;
        this.y = y;
    }

    public abstract boolean canMove(int x, int y, boolean isKilling);

    public abstract String getSymbol();

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void kill(){
        this.x = -1;
        this.y = -1;
        isDead = true;
    }

    public Side getSide() {
        return side;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    enum Side{
        BLACK,WHITE
    }
}
