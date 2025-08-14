// binary search in infinite array, simulate this in normal array without using array.length

public class InfiniteBinarySearch {
    public static void main(String[] args) {
        int[] myArr = {1,4,6,78, 123,234,566,1100, 4500,5613,7568, 9000,11000, 12345};
        int indexVal = findRange(myArr, 1100);

        System.out.println(indexVal);
    }

    // keep updating the range 
    static int findRange(int[] arr, int target) {
        // find the range first, starting with size 2
        int start = 0;
        int end = 1;

        while(target > arr[end]){
            int newStart = end+1;
            end = end + (end - start + 1)*2;
            start = newStart;
        }
        int idx = binary_search(arr, target, start, end);
        return idx;
    }

    // binary function
    static int binary_search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else
                return mid;
        }

        return -1;
    }
}
