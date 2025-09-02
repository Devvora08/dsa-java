// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matr = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matr);
    }

    static void setZeroes(int[][] matrix) {
        // take 2 arrays - row and columns, iterate once for marking 0 indexes, second time to update it
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // traverse 2nd time, make changes
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(rows[i]|| cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        // print the matrix
          for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
               System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
