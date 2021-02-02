package chess;

import java.awt.*;

/**
 * Also known as a Bishop
 */
public class Ut extends Piece{
    public Ut(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public boolean move(int startX, int startY, int x, int y) {
        //Only moves on diagonals
        int diffX = startX - x;
        int diffY = startY - y;
        return diffX == diffY;
    }
}
