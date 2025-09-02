// Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
// A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
// Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
// Output: [15]

import java.util.ArrayList;
import java.util.List;

public class LuckyNumMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 7, 8 },
                { 9, 11, 13 },
                { 15, 16, 17 }
        };

        List<Integer> ans = new ArrayList<>();
        ans = luckyNumbers(matrix);
        System.out.println(ans);
    }

    static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> lucky = new ArrayList<>();

        // traverse the matrix here entirely once, with a helper method that will check
        // lucky for each element
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (checkLucky(matrix, matrix[i][j], i, j)) {
                    lucky.add(matrix[i][j]);
                }
            }
        }
        return lucky;
    }

    static boolean checkLucky(int[][] matrix, int val, int row, int col) {
        // check if minimum in its row
        for (int j = 0; j < matrix[row].length; j++) {
            if (matrix[row][j] < val) {
                return false;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > val) {
                return false;
            }
        }

        return true;
    }
}
