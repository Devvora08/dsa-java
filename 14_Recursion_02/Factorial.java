// n = 5, fact = 5*4*3*2*1 = 120

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(0));
    }

    static int fact(int n) {
        if(n<=1) {
            return 1;
        }

        return n * fact(n-1);
    }
}
