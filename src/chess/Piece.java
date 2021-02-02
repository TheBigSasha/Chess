package chess;

import java.awt.*;

public abstract class Piece {
    private boolean isBlack;
    protected boolean isAlive;
    private int x, y;

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void kill() {
        isAlive = false;
    }


    public Piece(boolean isBlack){
        this.isBlack = isBlack;
    }

    public abstract boolean move(int x, int y);

    protected abstract boolean canMove(int x, int y);

    public boolean isBlack(){
        return isBlack;
    };
}
