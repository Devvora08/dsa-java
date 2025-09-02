// given n, print spiral array in 2d, from 1 - n^2
// eg, n = 6, 1 - 36 in spiral

public class SpiralArray2 {
    public static void main(String[] args) {
        int[][] array = spiralTwo(6);
        for (int[] row : array) {
            for (int num : row) {
                System.out.printf("%3d", num); // 3 spaces for alignment
            }
            System.out.println();
        }
    }

    static int[][] spiralTwo(int n) {
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int[][] nums = new int[n][n];
        int val = 1;

        while (top <= bottom && left <= right) {
            // 1st from left to right, top is constant
            for (int i = left; i <= right; i++) {

                nums[top][i] = val++;
            }
            top++;

            // 2nd from top to bottom, right is constant
            for (int i = top; i <= bottom; i++) {
                nums[i][right] = val++;
            }
            right--;

            // 3rd from right to left, bottom is constant,
            // only if top<=bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    nums[bottom][i] = val++;
                }
                bottom--;
            }

            // 4th from bottom to top, left is constant
            // only if left<=right
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    nums[i][left] = val++;
                }
                left++;
            }
        }

        return nums;
    }
}
