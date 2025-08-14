import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        nums = shift(nums);
        System.out.println(Arrays.toString(nums));
    }

    static int[] shift(int[] arr) {
        int insertPos = 0;
        for(int num: arr) {
            if(num!=0) {
                arr[insertPos] = num;
                insertPos++;
            }
        }
        while(insertPos<arr.length) {
            arr[insertPos] = 0;
            insertPos++;
        }

        return arr;
    }
}
