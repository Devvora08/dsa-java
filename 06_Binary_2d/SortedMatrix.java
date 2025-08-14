// array sorted in a sorted manner, not row and column wise

import java.util.Arrays;

public class SortedMatrix {
    // brute force = nxn complexity, linear search.
    // convert into 1d array, then linear search, n complexity
    public static void main(String[] args) {
        int[][] arrmatrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 13, 15, 20 },
                { 25, 34, 54, 60 }
        };

        System.out.println(Arrays.toString(searchSortedMatrix(arrmatrix, 15)));
    }

    static int[] searchSortedMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0;
        int c = cols - 1;

        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[] { r, c };
            }
            if (matrix[r][c] > target) {
                c--; // Move left
            } else {
                r++; // Move down
            }
        }

        return new int[] { -1, -1 }; // Not found
    }

    // search in row provided, where boundaries are col1 and col2
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[] { row, mid };
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }

    static int[] searchSorted(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;
        // run loop till 2 rows remain
        while (rStart < (rEnd - 1)) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target)
                return new int[] { mid, cMid };
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        } // end of the loop, 2 rows remain

        // check if middle column has target
        if (matrix[rStart][cMid] == target) {
            return new int[] { rStart, cMid };
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[] { rStart + 1, cMid };
        }

        // 4 checks if mid column does not have target, binary search on all these
        // ranges
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }

        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) {
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }

        if (target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }

        if (target <= matrix[rStart + 1][cMid + 1]) {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }

        return new int[] { -1, -1 };
    }
}
