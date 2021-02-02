package Chess2;

public abstract class Piece {
    protected int x, y;     //Accessible within package and to subclasses

    private boolean isDead;

    private boolean hasMoved = false;

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

    public boolean hasMoved() {
        return hasMoved;
    }

    public abstract void move(int x, int y);

    public void kill(){
        this.x = -1;
        this.y = -1;
        isDead = true;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    enum Side{
        BLACK,WHITE
    }
}
