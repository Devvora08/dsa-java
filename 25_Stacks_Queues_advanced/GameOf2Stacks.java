// You are given two integer arrays A and B, representing two stacks where the 0th element is the top of each stack, and an integer maxSum.
// You start with an empty total sum (sum = 0). At each move, you may pop the top element from either stack, adding its value to sum.
// Your goal is to maximize the number of elements removed without sum exceeding maxSum.
// Return the maximum number of moves you can make.

// Input:
// A = [4, 2, 4, 6, 1]
// B = [2, 1, 8, 5]
// maxSum = 10

// Output:
// 4

import java.util.Arrays;

public class GameOf2Stacks {
    public static void main(String[] args) {
        int max = 10;
        int[] a = {5,1,1,1,1};
        int[] b = {2,2,2,2,2};

        TwoStacks game = new TwoStacks();
        System.out.println(game.twoStacks(max, a, b));
    }
}

class TwoStacks {
    public int twoStacks(int x, int[] a, int[] b){
        return stacks(x, a, b, 0, 0) - 1;
    }

    private int stacks(int x, int[] a, int[] b, int sum, int count){
        if(sum > x) {
            return count; // base condition
        }

        if(a.length == 0 || b.length == 0) return count;

        int ans1 = stacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum+a[0], count+1);
        int ans2 = stacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum+b[0], count+1);

        return Math.max(ans1, ans2);
    }
}


