// simply check if array is sorted or not, using recursion
// [1,2,5,7] - sorted, [1,5,6,2,9] - not sorted
// to check, simply find if i < i+1 for each ith element using recursion, if bool = false, then not sorted

public class IsSorted { 
    public static void main(String[] args) {
        int[] myArr = {1,2,4,5,6,9,2};
        System.out.println(sorted(myArr, 0));
    }

    static boolean sorted(int[] arr,int idx) {
        if(idx == arr.length - 1) return true; // base condition

        return (arr[idx] < arr[idx+1] && sorted(arr, idx+1));
    }
}
