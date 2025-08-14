// find the rotation count in array = {15,18,2,3,6,12} - count = 2, position of pivot

public class RotationCount {
    public static void main(String[] args) {
        int[] rotatedArray = {12,15,16,17,19,2,4,7,8,10};
        int pivot = findPivot(rotatedArray);
        System.out.println(pivot+1);
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

    // use for duplicated rotated array 
    static int findDuplicatePivot(int[] arr) {
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
