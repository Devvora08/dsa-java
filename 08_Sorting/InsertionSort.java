// sort in chunks, {5,1,3,7,2,0} - sort idx 0,1, then 0,1,2 ..... o,n

public class InsertionSort {
    public static void main(String[] args) {
        int[] myArr = { 1, 9, 3, 6, 10, 12, 4, 8 };
        myArr = insertSort(myArr);

        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }
    }

    static int[] insertSort(int[] arr) {
        for(int i = 0; i< arr.length - 1; i++) {
            for(int j = i+1; j> 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }

        return arr;
    }
}
