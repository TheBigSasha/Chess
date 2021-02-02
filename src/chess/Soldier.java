package chess;

import java.awt.*;

/**
 * Also known as pawn
 */
public class Soldier extends Piece{
    private boolean hasMoved = false;

    public Soldier(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public boolean move(int startX, int startY, int x, int y) {
        hasMoved = true;
        return false;
    }
}
