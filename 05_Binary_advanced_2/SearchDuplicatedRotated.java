public class SearchDuplicatedRotated {
    public static void main(String[] args) {
        int[] rotatedArray = {12,12,15,15,15,2,4,7,7,8,8,10};
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
            
            // elementes - mid = start = end, skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // check if start is pivot
                if(arr[start] > arr[start+1]) return start; // start is pivot
                start++;
                if(arr[end] < arr[end-1]) return end -1; // end is pivot
                end--; 
            }
            // left side sorted, pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
