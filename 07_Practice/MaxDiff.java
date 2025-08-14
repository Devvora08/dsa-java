public class MaxDiff {
    public static void main(String[] args) {
        int[] arr = {7, 14, 5, 3, 2, 12};
        int maxD = maxDifference(arr);

        System.out.println(maxD);
    }

    static int maxDifference(int[] arr) {
        int difference = Integer.MIN_VALUE; // keep updating the value if bigger one found
        for(int i = 0; i<arr.length; i++) {
            for(int j = i+1; j<arr.length; j++) {
                // update the difference here, only if ith element is less than j
                if(arr[i] < arr[j]) {
                    if(difference < (arr[j]-arr[i])) {
                        difference = arr[j]-arr[i];
                    }
                }
            }
        }

        return difference;
    }
}
