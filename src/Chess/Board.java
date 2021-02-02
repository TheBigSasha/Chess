package Chess;

import java.util.ArrayList;

public class Board {
    private Piece[][] board;

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
        }else{
            throw new IllegalArgumentException("Illegal move");
        }
    }

    public boolean canMove(int x, int y, int destX, int destY) {
        Piece toMove = board[x][y];

        boolean killing = false;

        //Checks if the piece being moved is valid to be moved
        if (toMove == null) return false;


        //Checks if it is a kill and if it will hit a piece of the same side
        if(board[destX][destY] != null){
            killing = true;
            if(board[destX][destY].getSide() == toMove.getSide()){
                return false;
            }
        }

        //Check if it can move by the rules of the piece
        if (!toMove.canMove(destX, destY, killing)){ return false;}

        //Check collision on the way, if it is not a horsey
        if (!(toMove instanceof Knight)) {
            //Identify if it is diagonal, or linear

            int diffX = destX - x;
            int diffY = destY - y;

            //Diagonal
            if (diffX == diffY && Math.abs(diffX) > 1) {
                //Determine direction of move
                int startX = Math.min(x, destX);
                int endX = Math.max(x, destX);
                int startY = Math.min(y, destY);
                int endY = Math.max(y, destY);
                for(int i = startX + 1; i < endX; i++){
                    for(int j = startY + 1; j < endY; j++){
                        if(board[i][j] != null){

                                return false;
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
                            if(!(x == destX && j == destY) && j != y) {
                                return false;
                            }
                        }
                    }
                }else{
                    int startX = Math.min(x, destX);
                    int endX = Math.max(x, destX);
                    for(int j = startX; j < endX; j++){
                        if(board[j][y] != null){
                            if(!(y == destY && j == destX) && j != x) {
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
    }

    protected void resetGame(boolean isBlack){
        int kingRow = isBlack ? 0 : 7;
        int soldierRow = isBlack ? 1 : 6;       //TODO: check that black is 0 everywhere
        Piece.Side side = isBlack ? Piece.Side.BLACK : Piece.Side.WHITE;

        board[0][kingRow] = new Rook(0, kingRow, side);
        board[7][kingRow] = new Rook(7,kingRow, side);

        board[1][kingRow] = new Knight(1, kingRow, side);
        board[6][kingRow] = new Knight(6, kingRow, side);

        board[2][kingRow] = new Bishop(2, kingRow, side);
        board[5][kingRow] = new Bishop(5, kingRow, side);

        board[3][kingRow] = new King(3,kingRow,side);
        board[4][kingRow] = new Queen(4,kingRow,side);

        for(int i = 0; i < board[soldierRow].length; i++){
            board[i][soldierRow] = new Pawn(i, soldierRow, side);
        }
    }

    public King getKing(Piece.Side side){
        for(Piece[] array : board){
            for(Piece p : array){
                if(p instanceof King && p.getSide() == side){
                    return (King) p;
                }
            }
        }

        return null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == null){
                    sb.append(" ");
                }else{
                    sb.append(board[i][j].getSymbol());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Piece> getPieces(Piece.Side s){
        ArrayList<Piece> out = new ArrayList<Piece>();
        for(Piece[] array : board){
            for(Piece p : array){
                if(p != null && !p.isDead() && p.getSide() == s){
                    out.add(p);
                }
            }
        }
        return out;
    }


    public Piece get(int x, int y) {
        return board[x][y];
    }
}
