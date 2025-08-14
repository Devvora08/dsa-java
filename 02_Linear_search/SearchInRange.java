public class SearchInRange {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,7,8,9,0};
        int ans = range(arr, 4, 3, 7);

        System.out.println(ans);
    }

    static int range(int[] arr, int target, int start, int end){
        if(arr.length == 0) return -1;

        for(int i = start -1; i< end; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return Integer.MAX_VALUE;
    
    }

}
