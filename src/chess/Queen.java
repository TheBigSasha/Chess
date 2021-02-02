package chess;

import java.awt.*;

public class Queen extends Piece{
    public Queen(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public boolean move(int startX, int startY, int x, int y) {
        return false;
    }
}
