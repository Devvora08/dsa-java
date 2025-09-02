// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        rotateInPlace(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    static void rotateInPlace(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
    }
}
