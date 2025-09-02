// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Input: nums = [1,2,3,1]
// Output: 4

public class HouseRobber {
    public static void main(String[] args) {
        int[] house = { 2, 7, 9, 3, 1 };
        System.out.println(rob(house));
    }

    static int rob(int[] nums) {
        int prev1 = 0; 
        int prev2 = 0; 
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}

// dont submit to leetcode. practice DP properly then