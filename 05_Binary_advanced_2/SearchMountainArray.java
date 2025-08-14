public class SearchMountainArray {
    public static void main(String[] args) {

        int [] arr = {1,3,5,6,4,3,2,1};
        int search = searchInPeak(arr, 5);

        System.out.println(search);
        
    }   
    
    static int searchInPeak(int[] arr, int target) {
        // search in 2 parts, first ascending part,if not found, then descending part
        // find peak for that first
        int peakIdx = peakMountain(arr);
        // binary search on asc
        int idx = dynamic_binary(arr, target, 0, peakIdx);
        if(idx == -1) {
            // perform binary search on desc
            idx = dynamic_binary(arr, target,peakIdx+1, arr.length-1);
        }
        if(idx != -1) return idx;
        return -1;
    }

    static int dynamic_binary(int[] arr, int target, int start, int end) {
        // dynamic as 2nd half is desc
        // check if sorted array is asc or desc
        boolean isAsc = arr[start] < arr[end];

        if (isAsc) {
            // perform the regular way
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else
                    return mid;
            }
        }   
        // Descending 
        while(end>=start) {
            int mid = start + (end - start) / 2;
            if(target > arr[mid]) {
                end = mid-1;
            } else if(target < arr[mid]) {
                start = mid + 1;
            } else 
                return mid;
        }

        // no where found then return -1
        return -1;
    }

    static int peakMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2;
            if(arr[mid] < arr[mid+1]) {
                // in ascending part
                start = mid + 1;
            } else {
                // in descending part
                end = mid;
            }
        }

        return end; // or return end, start = end
    }

    
}
