package chess;

import java.awt.*;

public class Elephant extends Piece{
    public Elephant(boolean isBlack) {
        super(isBlack);
    }

    @Override
    public boolean move(int startX, int startY, int x, int y) {
        return false;
    }
}
