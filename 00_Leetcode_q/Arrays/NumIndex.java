// Given two arrays of integers nums and index. Your task is to create target array under the following rules:

// Initially target array is empty.
// From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
// Repeat the previous step until there are no elements to read in nums and index.
// Return the target array.

// Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
// Output: [0,4,1,3,2]

// It is guaranteed that the insertion operations will be valid.

import java.util.Arrays;

public class NumIndex {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4 };
        int[] idx = { 0, 1, 2, 2, 1 };
        System.out.println(Arrays.toString(createTargetArray(nums, idx)));
    }

    static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        int size = 0;

        for (int i = 0; i < nums.length; i++) {
            // shift elements right from 'index[i]' to 'size - 1'
            for (int j = size; j > index[i]; j--) {
                target[j] = target[j - 1];
            }
            // insert nums[i] at index[i]
            target[index[i]] = nums[i];
            size++;
        }

        return target;
    }
}
