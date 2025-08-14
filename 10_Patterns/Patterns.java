// Possible patterns : 
// *****
// *****
// *****
// *****
// *****,

// *****
// ****
// *** 
// ** 
// *            and much more

// Trick :
// Outer loop = number of lines to be printed, = Rows
// Inner loop = number of elements in each row = Columns

public class Patterns {
    public static void main(String[] args) {
        pattern7(5);
    }

    static void pattern1(int n) {
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= row; col++) {
                System.out.print(" * ");
            }

            System.out.println(" ");
        }
    }

    static void pattern2(int n) {
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col<= n; col++) {
                System.out.print(" * ");
            }
            System.out.println(" ");
        }
    }

    static void pattern3(int n) {
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col<= n - row + 1; col++) {
                System.out.print(" * ");
            }

            System.out.println(" ");
        }
    }

    static void pattern4(int n){
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= row; col++) {
                System.out.print(" * ");
            }

            System.out.println(" ");
        }
         for(int row = 1; row <= n-1; row++) {
            for(int col = 1; col<= n - row; col++) {
                System.out.print(" * ");
            }

            System.out.println(" ");
        }
    }

    static void pattern5(int n) {
        for (int row = 1; row <=n; row++) {
            for (int space = 0; space < n-row; space++) {
                System.out.print(" ");
            }

            for(int col = row; col >=1; col--) {
                System.out.print(col);
            }

            for(int col = 2; col<=row; col++){
                System.out.print(col);
            }

            System.out.println();
        }
    }

    static void pattern6(int n){
        for(int row = 0; row < 2*n; row++) {
            int totalColsInRow = row > n ? 2 * n - row: row;

            int numSpaces = n - totalColsInRow;
            for(int s = 0; s<numSpaces; s++) {
                System.out.print(" ");
            }

            for(int cols = 0; cols< totalColsInRow; cols ++ ){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    // 4 4 4 4 4 4 4 
    // 4 3 3 3 3 3 4
    // 4 3 2 2 2 3 4
    // 4 3 2 1 2 3 4
    // 4 3 2 2 2 3 4
    // 4 3 3 3 3 3 4 
    // 4 4 4 4 4 4 4  pattern7

    static void pattern7(int n) {
        int orignalN = n;
        n = 2*n;
        for(int row = 0; row<=n; row++) {
            for(int col = 0; col<= n; col++) {
                int atEveryIdx =orignalN - Math.min(Math.min(row, col), Math.min(n-row, n-col));
                System.out.print(atEveryIdx + " ");
            }

            System.out.println();
        }
    }


}
