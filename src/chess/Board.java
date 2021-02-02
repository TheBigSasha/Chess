package chess;

public class Board {
    private Piece[][] board;

    public Board(){
        board = new Piece[8][8];
        populateGame(board, true);
        populateGame(board, false);
    }

    public void move(int pX, int pY, int x, int y) {
        if(board[x][y] == null || board[x][y].isBlack() != board[pX][pY].isBlack() ) {
            if (board[pX][pY].move(x, y)) {
                if(board[x][y] instanceof King){
                    System.out.println("A WinRar is you!");
                }
                board[x][y] = board[pX][pY];
                board[pX][pY] = null;
            }
        }else{
            throw new IllegalArgumentException("Cannot kill a piece of the same color");
        }
    }

    public Piece[][] getBoard(){
        return board;
    }


    private static void populateGame(Piece[][] board, boolean isBlack){
        int kingRow = isBlack ? 0 : 7;
        int soldierRow = isBlack ? 1 : 6;

        board[kingRow][0] = new Elephant(isBlack);
        board[kingRow][7] = new Elephant(isBlack);


        board[kingRow][1] = new Horsey(isBlack);
        board[kingRow][6] = new Horsey(isBlack);


        board[kingRow][2] = new Ut(isBlack);
        board[kingRow][5] = new Ut(isBlack);

        board[kingRow][3] = new King(isBlack);
        board[kingRow][4] = new Queen(isBlack);

        for(int i = 0; i < 7; i++){
            board[soldierRow][i] = new Soldier(isBlack);
        }
    }
}