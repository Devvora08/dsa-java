// count num of steps to reduce a number to 0, if even - n/2, if odd, subtract -1

public class ReduceNumToZeroSteps {
    public static void main(String[] args) {
        System.out.println(countSteps(2, 0));
    }

    static int countSteps(int n, int count) {
        if(n == 0) return count;

        int divide = n%2;
        if(divide == 0) { 
            // its even so return with /2
            return countSteps(n/2, count+1);
        } else {
            // its odd so subtract 1
            return countSteps(n-1, count+1);
        }
    }
}
