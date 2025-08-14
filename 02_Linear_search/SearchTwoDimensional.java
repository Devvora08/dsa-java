import java.util.Arrays;

public class SearchTwoDimensional {
    public static void main(String[] args){
        int[][] arr = new int[][] {
            {1, 2, 4, 24, 121},
            {1, 56, 124, 98},
            {1, 2, 65, 235, 67, 98, 91, 304}
        };

        int target = 56;
        int[] val = search(arr, target);
        System.out.println(Arrays.toString(val));
    }

    static int[] search(int[][] arr, int tar){
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++){
                if (arr[row][col] == tar){
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
