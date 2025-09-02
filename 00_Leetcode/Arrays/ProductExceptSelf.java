// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] n = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(n)));
    }

    static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int [] ans = new int[nums.length];
        prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        suffix[nums.length-1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i = 0; i < ans.length; i++) {
            ans[i] = prefix[i] * suffix[i];
        }

        return ans;
    }
}
