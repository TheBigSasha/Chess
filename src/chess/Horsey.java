package chess;

import java.awt.*;

public class Horsey extends Piece{
    public Horsey(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public boolean move(int startX, int startY, int x, int y) {
        return false;
    }
}
