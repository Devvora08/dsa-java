// compare adjacent elements - {1,9,3,6,10,12,4,8} - 1 - 9 = 1,9, 9 - 3 = 3, 9 - swap
// also known as sinking/exchange sort

public class BubbleSort {
    public static void main(String[] args) {
        int[] myArr = { 1, 9, 3, 6, 10, 12, 4, 8 };
        myArr = bubbleSorting(myArr);

        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }
    }

    static int[] bubbleSorting(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {     
                if (arr[j] < arr[j - 1]) {             // arr[j] > arr[j-1] - this will put arr in desc order
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;           // if in any case, swapping remains false, it means arr = sorted, so exit method
                }
            }

            if(!swapped) {
                break;
            }
        }

        return arr;
    }
}
