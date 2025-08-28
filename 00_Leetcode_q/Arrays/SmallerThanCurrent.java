// Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
// That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

// Return the answer in an array.
// Input: nums = [8,1,2,2,3]
// Output: [4,0,1,1,3]

import java.util.Arrays;

public class SmallerThanCurrent {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }

    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] countSmaller = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                if(nums[i] > nums[j]) count+=1;
            }
            countSmaller[i] = count;
        }

        return countSmaller;
    }
}
