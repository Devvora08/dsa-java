// find missing number from 0-N range - {0,4,2,1}- missing = 3

public class ZeroToNMissing {
    public static void main(String[] args) {
        // sort using cyclic sort, then do a linear traverse to find the wrong pair of idx-val. return idx
        // if no wrong pair found, return n, {0,1,3,2} - 0-4, so return n
         int[] myArr = {0,1,2,3,4};
         int missing = cyclicSort(myArr);

         System.out.println(missing);
    }

    static int cyclicSort(int[]arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIdx = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correctIdx]) {
                swap(arr, i, correctIdx);
            } else {
                i++;
            }
        }

        // search for the wrong idx-val pair else return N
        for(int idx = 0; idx<arr.length; idx++) {
            if(arr[idx] != idx) {
                return idx;
            } 
        }

        return arr.length;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
