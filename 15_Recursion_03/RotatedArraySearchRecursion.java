// use recursion to find element in a rotated array. 
// {5,6,7,8,9,1,2,3} - target = 7 - idx = 2
// use binary search

public class RotatedArraySearchRecursion {
    public static void main(String[] args) {
        int[] myArr = {5,6,7,8,9,1,2,3};
        int target = 7;
        System.out.println(search(myArr, target, 0, myArr.length-1));
    }   
    
    static int search(int[] arr, int target, int s, int e) {
        if(s>e) return -1;

        int m = s + (e-s) / 2;
        if(arr[m] == target) return m;

        if(arr[s] <= arr[m]) {
            if(target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m-1);
            } else {
                return search(arr, target, m+1, e);
            }
        }

        if(target >= arr[m] && target <= arr[e]) {
            return search(arr, target, m+1, e);
        }
        return search(arr, target, s, m-1);
    }
}
