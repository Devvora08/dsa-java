// Place N knights on an N×N chessboard so that no knight attacks another.
// A knight moves in an L-shape:

// 2 squares in one direction, then 1 square perpendicular
// 1 square in one direction, then 2 squares perpendicular

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];

        knight(board, 0, 0, 3);
    }

    static void knight(boolean[][] board, int row, int col, int knights) {
        if(knights == 0) {
            display(board);
            System.out.println();
            return;
        }

        if(row == board.length - 1 && col == board.length) {
            return;
        }

        if(col == board.length) {
            knight(board, row+1, 0, knights);
            return;
        }

        if(isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        knight(board, row, col+1, knights);
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if(isValid(board, row-2, col-1)) {
            if(board[row-2][col-1]) {
                return false;
            }
        }

        if(isValid(board, row-1, col-2)) {
            if(board[row-1][col-2]) {
                return false;
            }
        }

        if(isValid(board, row-2, col+1)) {
            if(board[row-2][col+1]) {
                return false;
            }
        }

        if(isValid(board, row-1, col+2)) {
            if(board[row-1][col+2]) {
                return false;
            }
        }

        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if(row >= 0 && row < board.length && col >= 0  && col < board.length) {
            return true;
        } 
        return false;
    }

     static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean col : row) {
                System.out.print(col ? "K " : "O ");
            }
            System.out.println();
        }
    }
}

// Eg - n = 3

// K . K
// . . .
// . K .