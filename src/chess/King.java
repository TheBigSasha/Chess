package chess;

import java.awt.*;

public class King extends Piece{
    public King(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public boolean move(int x, int y) {
        return false;
    }

    @Override
    protected boolean canMove(int x, int y) {
        return false;
    }
}
