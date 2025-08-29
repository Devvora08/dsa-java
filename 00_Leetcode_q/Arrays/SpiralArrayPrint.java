// print spiral array in linear way

public class SpiralArrayPrint {
    public static void main(String[] args) {
        int[][] spiralMatrix = {
                { 1, 2, 3, 4, 5, 6 },
                { 20, 21, 22, 23, 24, 7 },
                { 19, 32, 33, 34, 25, 8 },
                { 18, 31, 36, 35, 26, 9 },
                { 17, 30, 29, 28, 27, 10 },
                { 16, 15, 14, 13, 12, 11 }
        };
        
        spiral(spiralMatrix);
    }

    static void spiral(int[][] nums) {
        int r = nums.length - 1;
        int c = nums[r].length - 1;

        // four pointers - Top, Bottom, Right, Left
        int top = 0;
        int bottom = r;
        int left = 0;
        int right = c;

        while (top <= bottom && left <= right) {
            // 1st from left to right, top is constant
            for (int i = left; i <= right; i++) {
                System.out.print(nums[top][i] + " ");
            }
            top++;

            // 2nd from top to bottom, right is constant
            for (int i = top; i <= bottom; i++) {
                System.out.print(nums[i][right] + " ");
            }
            right--;

            // 3rd from right to left, bottom is constant,
            // only if top<=bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(nums[bottom][i] + " ");
                }
                bottom--;
            }

            // 4th from bottom to top, left is constant
            // only if left<=right
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(nums[i][left] + " ");
                }
                left++;
            }
        }
    }
}
