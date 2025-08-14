// select element from arr, and place in its correct index

public class SelectionSort {
    public static void main(String[] args) {
        int[] myArr = { 1, 9, 3, 6, 10, 12, 4, 8 };
        myArr = selectSort(myArr);

        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }
    }

    static int[] selectSort(int[] arr) {
        for(int i = 0; i< arr.length; i++) {
            int last = arr.length - 1 - i;
            int maxIdx = getMax(arr, 0, last);
            // swap the max idx element with the last
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[last];
            arr[last] = temp;
        }

        return arr;
    }

    static int getMax(int[] arr, int start, int end) {
        int max = start;
        for(int i = start; i<= end; i++) {
            if(arr[max] < arr[i]) {
                max = i;
            }
        }

        return max;
    }
}
