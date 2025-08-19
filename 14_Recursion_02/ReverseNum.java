// reverse a num n, n = 123, ans = 321 using recursion

public class ReverseNum {
    public static void main(String[] args) {
        reverse(4321);
        System.out.println(sum);
    }

    static int sum = 0;  // takes a helper variable outside the function
    static void reverse(int n) {
        if(n == 0) return;
        int rev = n%10;
        sum = sum*10 + rev;
        
        reverse(n/10);
    }
}
