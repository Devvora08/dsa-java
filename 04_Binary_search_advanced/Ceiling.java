// ceiling = smallest number in the array greater or equal to the target
// arr = [1,3,5,6,9,14,17,20], target = 7, ceil = 9.  if target = 11, ceil = 14., if tar = 14, ceil = 14

public class Ceiling{
    public static void main(String[] args) {
        int[] myArr = {2,3,5,9,14,16,18};
        int target = 0;
        int ceilAns = ceiling(myArr, target);

        System.out.println(ceilAns);
    }

    static int ceiling(int[] arr, int target) {
        // do binary search
        int start = 0;
        int end = arr.length-1;

        // put a check to return the first element if target lesser than that for ceil case
        if(target < arr[start]) return arr[start];

        if(target > arr[end]) return -1;
        
        while(start<end) {
            int mid = start + (end-start)/2;
            if(target < arr[mid]) {
                end = mid -1;
            } else if(target > arr[mid]) {
                start = mid +1;
            } else 
                return arr[mid];
        }

        return arr[start];
    }
}

// when while is violated, meaning, target isnt found in arr using binary, start > end, where start > target > end, hence return start