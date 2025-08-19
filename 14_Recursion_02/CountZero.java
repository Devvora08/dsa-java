// count number of 0s in a number : 30204 - 2

public class CountZero {
    public static void main(String[] args) {
        System.out.println(count(20030004, 0));
    }

    static int count(int n, int c) {
        if(n==0) return c;
        int remainder = n%10;
        if(remainder == 0) return count(n/10, c+1);

        return count(n/10, c);
    } 
}
