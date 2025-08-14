public class Linear {
    public static void main(String[] args){

        int[] myArr = {1,2,4,5,6,67,78,7134};
        int target = 244;

        int ans = linearSearch(myArr, target);
        System.out.println(ans);

    }

    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) return -1;

        for(int i = 0; i < arr.length; i++){
            
            int element = arr[i];
            if(element == target){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
