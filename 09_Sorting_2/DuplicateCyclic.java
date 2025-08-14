// return duplicate number from range 1-N.
// {4, 5, 2, 7, 8, 2, 3, 1} - duplicate = 2

public class DuplicateCyclic {
    public static void main(String[] args) {
        int[] myArr = {1,2,5,4,7,8,3,8};
        int missing = cyclicSort(myArr);

        System.out.println(missing);
    }   
    
    static int cyclicSort(int[] arr) {
        int i = 0;
        while(i < arr.length) {
            int correctIdx = arr[i] - 1;
            if(arr[correctIdx] != arr[i]) {
                // swap
                int temp = arr[correctIdx];
                arr[correctIdx] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        } // after loop array is sorted

        for(int idx = 0; idx < arr.length; idx ++) {
            if(arr[idx] != idx + 1) {
                return arr[idx];
            }
        }

        return -1;
    }
}
