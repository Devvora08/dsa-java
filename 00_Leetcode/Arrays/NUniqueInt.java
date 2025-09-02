// Given an integer n, return any array containing n unique integers such that they add up to 0.

// Input: n = 5
// Output: [-7,-1,1,3,4]

// n = 6, 6/2 = 3. so add 1 -> 3, including -1 -> -3
// n = 5, 5/2 = 2. so add 1 -> 2, including -1 > -2, and a 0.

import java.util.Arrays;

public class NUniqueInt {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
        System.out.println(Arrays.toString(sumZero(8)));
    }

    static int[] sumZero(int n) {
        
        int[] ans = new int[n];
        int index = 0;

         for (int i = 1; i <= n / 2; i++) {
            ans[index] = i;
            index++;
            ans[index] = -i;
            index++;
        }

        // If odd, last element is 0
        if (n % 2 != 0) {
            ans[index] = 0;
        }

        return ans;
    }
}
