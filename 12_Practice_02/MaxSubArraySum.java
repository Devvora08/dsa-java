// You are given an integer array nums and an integer k.
// Find the maximum sum of any subarray of size k.

// Input: nums = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4  
// Output: 39  
// Explanation: Subarray [4,2,10,23] has the maximum sum = 39


// Not learnt sliding window, pointer approach yet, so sort the array, return sum of last k elements.

import java.util.Arrays;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] myArr = {5, -10, 6, 90, 3};
        int k = 2;
        myArr = bubbleSort(myArr);
        System.out.println(Arrays.toString(myArr)); 

        int maxSum = sumArray(myArr, k);
        System.out.println(maxSum);
    }

    static int[] bubbleSort(int[] arr) {
        // sort the array
        boolean swapped = false;
        for(int i = 0; i<arr.length; i++) {
            for(int j=1; j< arr.length - i; j++) {
                if(arr[j] > arr[j-1]) {
                    swap(arr, j, j-1);
                    swapped = true;
                }
            }

            if(!swapped) break;
        }

        return arr;
    }

    static int sumArray(int[] arr, int n) {
        if(arr.length<4) return -1;
        int sum = 0;
        for(int i = 0;i<n;i++) {
            sum += arr[i];
        }

        return sum;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
