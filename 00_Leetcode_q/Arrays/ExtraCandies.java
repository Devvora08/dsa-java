// There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has,
// and an integer extraCandies, denoting the number of extra candies that you have.

// Return a boolean array result of length n, where result[i] is true if,
// after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

// Input: candies = [2,3,5,1,3], extraCandies = 3
// Output: [true,true,true,false,true] 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtraCandies {
    public static void main(String[] args) {
        int[] candies = { 1, 4, 3, 2, 1, 2 };
        int extra = 2;
        List<Boolean> result = kidsWithCandies(candies, extra);
        System.out.println(Arrays.toString(result.toArray()));
    }

    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(checkMax(candies, i, extraCandies));
        }

        return result;
    }

    static boolean checkMax(int[] candies, int idx, int extra) {
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > (candies[idx] + extra)) {
                return false;
            }
        }

        return true;
    }
}
