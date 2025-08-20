// divide and conquer, ex - [8,3,4, 12,5,6]
// [8,3,4] and [12,5,6] - divide into 2 parts, sort and keep dividing and keep sorting, and merge the sorted 
// [3,4,8] and [5,6,12] - now merge 2 sorted arrays - [3,4,5,6,8,12]
// merge each 2 arrays at a time using pointers
// keep dividing till there is 1 element array each for all

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] myarr = {5,4,3,7,8,1,10};
        mergeSortInPlace(myarr, 0, myarr.length);
        System.out.println(Arrays.toString(myarr));   
    }

    
    // this is not inplace method, a copy is made at every level of the original arr
    static int[] mergeSort(int[] arr) {
        if(arr.length == 1) return arr;  // base condition

        int mid = arr.length/2;
        
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeArrays(left, right);
    }

    static int[] mergeArrays(int[] first, int[] second) {
        int[] mix = new int[first.length+second.length];

        int i = 0; // for first
        int j = 0; // for second
        int k = 0; // for mix 

        while(i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one arrays remains incomplete after while loop, so add them
        while(i<first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while(j<second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }



    // this is in place merge sort
    static void mergeSortInPlace(int[] arr, int s, int e) {
        if(e - s == 1) return;  // base condition

        int mid = (s+e)/2;
        
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr,s,mid, e);
    }

    static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e-s];

        int i = s;
        int j = m;
        int k = 0;

        while(i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }
    
}



// Time complexity 
// At every level, N elements are being merged. N comparisions are made for N elements for logN levels 
// Therefore - complexity is - O(NlogN)


