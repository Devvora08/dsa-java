import java.util.ArrayList;

public class HappyNum {
    public static void main(String[] args) {
        int num = 19;
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(isHappy(num, arr));
    }

    static boolean isHappy(int n, ArrayList<Integer> nums) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        if (sum == 1)
            return true; // found happy number
        if (nums.contains(sum))
            return false; // cycle detected

        nums.add(sum);
        return isHappy(sum, nums); // return recursive result
    }
}
