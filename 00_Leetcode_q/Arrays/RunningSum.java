// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
// Return the running sum of nums.

// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int[] ans = runningSum(nums);

        System.out.println(Arrays.toString(ans));
    }

    static int[] runningSum(int[] nums) {
        int sum = 0;
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans[i] = sum;
        }

        return ans;
    }
}
