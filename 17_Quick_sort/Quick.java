// choose a pivot in the array. after first pass, all elements < p will be on lhs of p
// and all elements > p will be rhs of p
// [5,4,3,2,1] - p = 4, then [1,3,2,4,5] - after first pass. keep doing that till sorted

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] myArr = {5,4,3,2,1};
        sort(myArr, 0, myArr.length-1);
        System.out.println(Arrays.toString(myArr));
    }

    static void sort(int[] nums, int low, int high) {
        if(low >= high) return;
        int start = low;
        int end = high;

        int mid = start + (end-start)/2 ;
        int pivot = nums[mid];

        while(start <= end) {
            while(nums[start] < pivot) {
                start ++;
            } 
            while(nums[end] > pivot) {
                end--;
            }
            if(start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // now pivot is at correct index, sort 2 half - low-end, start-high
        sort(nums, low, end);
        sort(nums, start, high);
    }
}

// time complextiy - best case - O(n^2) worst case - O(nlogn)
