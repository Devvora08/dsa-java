import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] myArr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int ans[] = remove(myArr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] remove(int[] nums) {


        int writeIndex = 1; // Position to write the next unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        return nums;
    }
}
