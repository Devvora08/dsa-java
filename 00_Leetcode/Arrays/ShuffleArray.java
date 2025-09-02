// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
// Return the array in the form [x1,y1,x2,y2,...,xn,yn].

// Input: nums = [2,5,1,3,4,7], n = 3
// Output: [2,3,5,4,1,7] 
// Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int[] ans = shuffle(nums, 3);

        System.out.println(Arrays.toString(ans));
    }

    static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < n; i++) {
            ans[2*i] = nums[i]; // xi
            ans[2*i+1] = nums[n + i]; // yi
        }

        return ans;
    }
}
