public class MaxWealth {
    public static void main(String[] args){
        int[][] wealthArray = {
            {1,23,45},
            {3, 12,42},
            {66,100,100}
        };

        int ans = maxWealth(wealthArray);
        System.out.println("Highest wealth income is : "+ ans);
    }

    static int maxWealth(int[][] arr){
        int ans = Integer.MIN_VALUE;

        for(int person = 0; person < arr.length; person++) {
            int temp = 0;
            for(int wealth = 0; wealth < arr[person].length; wealth++){
                temp += arr[person][wealth];
            }   
            if (temp>ans){
                ans = temp;
            }
        }
        return ans;
    }
}


