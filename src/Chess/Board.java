package Chess;

public class Board {
    private Piece[][] board;
    private Piece.Side lastMove;

    public Board(){
        resetGame();
    }

    public void move(int x, int y, int destX, int destY) {
        if(canMove(x,y,destX,destY)){
            if(board[destX][destY] != null){
                board[destX][destY].kill();
            }
            board[x][y].move(destX,destY);
            board[destX][destY] = board[x][y];
            board[x][y] = null;
            lastMove = board[destX][destY].getSide();
        }else{
            throw new IllegalArgumentException("Illegal move");
        }
    }

    public boolean canMove(int x, int y, int destX, int destY) {
        Piece toMove = board[x][y];

        boolean killing = false;

        //Checks if the piece being moved is valid to be moved
        if (toMove == null) return false;

        //Checks last move
        if(toMove.getSide() == lastMove) return false;

        //Checks if it is a kill and if it will hit a piece of the same side
        if(board[destX][destY] != null){
            killing = true;
            if(board[destX][destY].getSide() == toMove.getSide()){
                return false;
            }
        }

        //Check if it can move by the rules of the piece
        if (!toMove.canMove(destX, destY, killing)) return false;

        //Check collision on the way, if it is not a horsey
        if (!toMove.canHop()) {
            //Identify if it is diagonal, or linear

            int diffX = destX - x;
            int diffY = destY - y;

            //Diagonal
            if (diffX == diffY && Math.abs(diffX) > 1) {
                //Determine direction of move
//                int dirX = diffX > 0 ? 1 : -1;
//                int dirY = diffY > 0 ? 1 : -1;
                int startX = Math.min(x, destX);
                int endX = Math.max(x, destX);
                int startY = Math.min(y, destY);
                int endY = Math.max(y, destY);
                for(int i = startX; i < endX; i++){
                    for(int j = startY; j < endY; j++){
                        if(board[i][j] != null){
                            if(!(i == destX && j == destY)) {
                                return false;
                            }
                        }
                    }
                }

            }

            //Linear
            if((diffX == 0 && Math.abs(diffY) > 1)|| (diffY == 0 && Math.abs(diffX) > 1)){
                if(diffX == 0){
                    int startY = Math.min(y, destY);
                    int endY = Math.max(y, destY);
                    for(int j = startY; j < endY; j++){
                        if(board[x][j] != null){
                            if(!(x == destX && j == destY)) {
                                return false;
                            }
                        }
                    }
                }else{
                    int startX = Math.min(x, destX);
                    int endX = Math.max(x, destX);
                    for(int j = startX; j < endX; j++){
                        if(board[y][j] != null){
                            if(!(y == destY && j == destX)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;

    }

    public void resetGame(){
        board = new Piece[8][8];        //Empty the board
        resetGame(true);          //Fill black
        resetGame(false);         //Fill white
        lastMove = Piece.Side.BLACK;
    }

    protected void resetGame(boolean isBlack){
        int kingRow = isBlack ? 0 : 7;
        int soldierRow = isBlack ? 1 : 6;       //TODO: check that black is 0 everywhere
        Piece.Side side = isBlack ? Piece.Side.BLACK : Piece.Side.WHITE;

        board[kingRow][0] = new Rook(0, kingRow, side);
        board[kingRow][7] = new Rook(7,kingRow, side);

        board[kingRow][1] = new Knight(1, kingRow, side);
        board[kingRow][6] = new Knight(6, kingRow, side);

        board[kingRow][2] = new Bishop(2, kingRow, side);
        board[kingRow][5] = new Bishop(5, kingRow, side);

        board[kingRow][3] = new King(3,kingRow,side);
        board[kingRow][4] = new Queen(4,kingRow,side);

        for(int i = 0; i < 7; i++){
            board[soldierRow][i] = new Pawn(i, soldierRow, side);
        }
    }

}
