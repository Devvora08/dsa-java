public class Sudoku {
    public static void main(String[] args) {
         int[][] board = new int[][]{
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if(solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }
    }   

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;


        // this is how we replace r,c from arguements
        for(int i = 0; i< n; i++) {
            for(int j = 0; j< n; j++) {
                if(board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            // after each row, if found some empty element in row, then break
            if(emptyLeft == false) break;
        }

        if(emptyLeft == true) return true; // sudoku is solved

        // backtrack
        for(int number = 1; number <=9; number++){
            if(isSafe(board, row, col, number)) {
                board[row][col] = number;
                if(solve(board)) {
                    // answer is found
                    return true;
                } else {
                    // backtrack here
                    board[row][col] = 0;
                }
            }
        }

        return false;
    }

    static void display(int[][] board) {
        for(int[] row: board) {
            for(int num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    static boolean isSafe(int[][] board, int row, int col, int num) {
        // check the row line
        for(int i = 0; i< board.length; i++) {
            // check if num is in that row line
            if(board[row][col] == num) {
                return false;
            }
        }

        // check col line
        for(int[] nums: board) {
            // check if num is in that col line
            if(nums[col] == num) {
                return false;
            }
        }


        // check 3x3 block
        int sqrt = (int)(Math.sqrt(board.length));
        int start = row - row % sqrt;
        int colStart = col - col % sqrt;

        for(int r = start; r < start+sqrt; r++) {
            for(int c = colStart; c < colStart+sqrt; c++) {
                if(board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
