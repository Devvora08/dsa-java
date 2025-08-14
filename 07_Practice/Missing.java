public class Missing { // do with cyclic sort here
    public static void main(String[] args) {
        int[] distinct = {1,2,3,4,6,7,8};
        int missingNum = missing(distinct);

        System.out.println(missingNum);
    }

    static int missing(int[] arr) {
        int givenSum = 0;
        int n = arr.length+1;
        int realSum = n*(n+1)/2;
        for(int i = 0; i<arr.length; i++) {
            givenSum += arr[i];
        }
        return realSum-givenSum;
    }
}
