//given sorted array, return range of target element in the array
// [1,3,5,6,6,7,9] =target = 6, so [3,4], if not found, [-1,-1]

public class FirstLastPos {
    public static void main(String[] args) {
        int[] myArr = { 1, 4, 6, 6, 7, 12, 15, 19 };
        int target = 6;

        int[] ans = searchRange(myArr, target);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static int[] linearSearch(int[] nums, int target) {

        int [] ans = new int[2];
        // brute force using 2 linear searches
        for(int i = 0; i<nums.length; i++) {
            if (nums[i] == target) {
                ans[0] = i;
            }
        }

        for(int i = nums.length-1; i>0; i--) {
            if (nums[i] == target) {
                ans[1] = i;
            }
        }

        return ans;
    }

    static int[] searchRange(int[] nums, int target) {

        int[] ans = { -1, -1 };
        int start = search(nums, target, true);
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;

    }

    static int search(int[] nums, int target, boolean findStartIndex) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
