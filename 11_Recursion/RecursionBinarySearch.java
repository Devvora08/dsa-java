public class RecursionBinarySearch {
    public static void main(String[] args) {
        int[] myarr = {2,4,6,7,10,14,16,20};
        int target = 11;
        
        int idx = binarySearch(myarr, target, 0, 7);
        System.out.println(idx);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        // binary search using recursion
        if(start > end) return -1;
        int mid = start + (end - start)/2;

        if(target == arr[mid]) return mid;
        if(target < arr[mid]) {
            return binarySearch(arr, target, start, mid-1);
        } else {
            return binarySearch(arr, target, mid+1, end);
        }
    }
}
