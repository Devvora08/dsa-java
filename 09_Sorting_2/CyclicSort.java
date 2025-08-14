// when given numbers from range - 1, N ----> use cyclic sort [note - range means a consecutive numbers - 1,2,3,4,5,6,7,etc];
// cycle sort - swap values indexes with correct index
// {1,5,3,2,4} - {swap 5(1) with 4(4)}

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] myArr = {1,5,3,2,4};
        myArr = sort(myArr);
        System.out.println(Arrays.toString(myArr));
    }

    static int[] sort(int[] arr) {
        int i = 0;
        while(i<arr.length) {
            int correctIdx = arr[i] - 1;
            if(arr[correctIdx] != arr[i]) {      // only works with a range of numbers from 1/0/continuous-N
                swap(arr, i , correctIdx);
            } else {
                i++;
            }
        }

        return arr;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
