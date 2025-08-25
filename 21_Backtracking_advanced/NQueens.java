// Place N queens on an N×N chessboard so that no two queens attack each other (i.e., no two share a row, column, 
// or diagonal).
// The classic solution is backtracking: place queens row by row, only in columns that aren’t threatened.
// Use bitmasks to track blocked columns and diagonals efficiently.

// State per row r:
// cols → columns already used
// diag1 → “/” diagonals (r+ c)
// diag2 → “\” diagonals (r − c)
// Try each safe column, recurse to next row, backtrack.
// Time: exponential in the worst case; with pruning it’s fast enough for typical N (e.g., N=8).

public class NQueens {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // vertical check
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }

        // diagonal top-left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) return false;
        }

        // diagonal top-right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }

        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean col : row) {
                System.out.print(col ? "Q " : "O ");
            }
            System.out.println();
        }
    }
}

// time complexity = O(n^3 + N!) = O(N!)

// N=4 → 

// Solution:
//      0  1  2  3
//    +---+---+---+---+
//  0 | .| Q| .| . |
//    +---+---+---+---+
//  1 | .| .| .| Q |
//    +---+---+---+---+
//  2 | Q| .| .| . |
//    +---+---+---+---+
//  3 | .| .| Q| . |
//    +---+---+---+---+
