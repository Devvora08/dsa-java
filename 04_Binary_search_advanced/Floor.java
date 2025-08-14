// floor = greatest number in the array smallr or equal to the target
// arr = [1,3,5,6,9,14,17,20], target = 7, floor = 6.  if target = 11, ceil = 9., if tar = 14, ceil = 14

public class Floor {
    public static void main(String[] args) {
        int[] myArr = {2,3,5,9,14,16,18};
        int target = 28;
        int ceilAns = floor(myArr, target);

        System.out.println(ceilAns);
    }

    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        // put a check to return the last element if target greater than that for floor case
        if(target > arr[end]) return arr[end];

        if(target < arr[start]) return -1;

        while(start<end) {
            int mid = start + (end-start)/2;
            if(target < arr[mid]) {
                end = mid -1;
            } else if(target > arr[mid]) {
                start = mid +1;
            } else 
                return arr[mid];
        }

        return arr[end];
    
    }
}

// when while is violated, meaning, target isnt found in arr using binary, start > end, where start > target > end, hence return end
