// find the peak in the array, [1,2,4,5,6,4,2,1] - peak = 6, idx = 4

public class PeakMountain {
    public static void main(String[] args) {
        int[] myarr = {1,3,5,6,7,5,3,2,1};
        int ans = peak(myarr);
        System.out.println(ans);
    }   

    static int peak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
      
        while(start < end) {
            int mid = start + (end-start)/2;

            if(arr[mid] < arr[mid+1]) {
                start = mid + 1;
            } else if(arr[mid] > arr[mid+1]) {
                end = mid;
            }
        }
        return start;
    }
}
