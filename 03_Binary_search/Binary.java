public class Binary {
    public static void main(String[] args) {
        int[] myArr = { 2, 5, 13, 55, 65, 235, 456, 3567, 8543 };
        System.out.println(myArr);
        int [] descArr = {9,8,7,6,5,4,3,2,1};
        int target = 8;

        int idx = dynamic_binary(descArr, target);
        System.out.println(idx);
    }

    static int binary_search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

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

    static int dynamic_binary(int[] arr, int target) {
        // check if sorted array is asc or desc
        int start = 0;
        int end = arr.length - 1;
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
}
