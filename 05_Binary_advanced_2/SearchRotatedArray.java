// rotated sorted array = {12,15,2,4,7,8,10} - clockwise rotated sorted array, with 2 as orginial first idx(2 cycles)
// pivot = 15, from where the next numbers are ascending

// find pivot, then find in 2 sorted parts

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] rotatedArray = {12,15,2,4,7,8,10};
        int target = 8;

        int pivot = searchRotated(rotatedArray, target);
        System.out.println(pivot);
    }

    static int searchRotated(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(nums[pivot] == target) return pivot;

        if(target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot-1);
        }
        return binarySearch(nums, target, pivot+1, nums.length-1);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

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

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length -1 ;
        while(start <=  end) {
            int mid = start + (end - start) /2 ;
            // 4 cases
            if(mid< end && arr[mid] > arr[mid+1]) {
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            } 
            if(arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
