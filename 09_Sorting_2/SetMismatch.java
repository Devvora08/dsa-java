import java.util.*;

public class SetMismatch {
    public static void main(String[] args) {
        int[] myArr = {4, 5, 2, 7, 8, 2, 3, 1};
        List<Integer> missing = findMissing(myArr);
        System.out.println(missing);
    }

    static List<Integer> findMissing(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i] - 1;
            // Only swap if the number is in range and not already in the correct position
            if (arr[i] != arr[correctIdx]) {
                swap(arr, i, correctIdx);
            } else {
                i++;
            }
        }

        // After sorting, find missing numbers
        List<Integer> missing = new ArrayList<>();
        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] != idx + 1) {
                missing.add(arr[idx]);
                missing.add(idx + 1);  // return index position, and the value
            }
        }
        return missing;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
