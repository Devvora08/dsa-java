// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

import java.util.Arrays;

public class FirstLastPositionArray {
    public static void main(String[] args) {
        int[] arr = { 5,7,7,8,8,10 };
        int t = 5;
        int[] ans = new int[2];
        ans[0] = findFirst(arr, t);
        ans[1] = findLast(arr, t);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] arr = { 5,7,7,8,8,10 };
        int t = 8;
        int[] ans = new int[2];
        ans[0] = findFirst(arr, t);
        ans[1] = findLast(arr, t);

        return ans;
    }

    static int findFirst(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int idx = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target <= arr[mid]) {
                if (arr[mid] == target) {
                    idx = mid; // store mid here, keep searching left
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return idx;
    }

    static int findLast(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int idx = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target >= arr[mid]) {
                if (arr[mid] == target) {
                    idx = mid; // store mid here, keep searching left
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return idx;
    }
}
