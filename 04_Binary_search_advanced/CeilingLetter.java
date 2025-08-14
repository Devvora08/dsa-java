// return letter greater than the target
public class CeilingLetter {
    public static void main(String[] args) {
        int[] myArr = {'a','d','e','i','o','u','t'};
        int target = 'z';
        int ceilAns = ceiling(myArr, target);

        System.out.println(ceilAns);
    }  
    
    static int ceiling(int[] arr, int target) {
       int start = 0;
       int end = arr.length-1;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(target < arr[mid]) {
                end = mid -1;
            } else if(target > arr[mid]) {
                start = mid +1;
            }
        }

        return arr[start%arr.length]; 
    }
}
