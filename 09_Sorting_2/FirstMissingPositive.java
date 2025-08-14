// given an unsorted int array, return the smallest missng positive integer. code in O(n) time
// nums = [1, 2, 0] -> Output: 3 (1 and 2 are present, 3 is the smallest missing positive)
// nums = [3, 4, -1, 1] -> Output: 2 (1 is present, 2 is the smallest missing positive)
// nums = [7, 8, 9, 11, 12] -> Output: 1 (1 is the smallest missing positive) 

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] myArr = {7,8,9};
        int firstPos = missing(myArr);

        System.out.println(firstPos);
    }

    static int missing(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIdx = arr[i] - 1; // ignore the -ve integers
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIdx]) {
                swap(arr, i , correctIdx);
            } else {
                i++;
            }
        }

        for(int index = 0; index<arr.length; index++) {
            if(arr[index] != index+1) {
                return index + 1;
            }
        }

        return arr.length + 1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
