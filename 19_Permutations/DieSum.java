// given a die of 6 sides, give all possible combinations to make up sum k
// ex - k = 4, [1111, 112, 22, 31,4,121, ...]

public class DieSum {
    public static void main(String[] args) {
        diceCombinations("", 4);
    }

    static void diceCombinations(String p, int target) {
        if(target == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i<= target; i++) {
            diceCombinations(p+i, target - i);
        }
    }
}
