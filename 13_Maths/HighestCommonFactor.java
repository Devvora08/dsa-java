// find highest common factor of a number n, m. ex - 20,25 - hcf = 5
// use by formula - Euclid's algorithm
// hcf(a,b) = hcf(reminder(b,a), a) - use recursion

public class HighestCommonFactor {
    public static void main(String[] args) {
        System.out.println(hcf(0, 25));
    }

    static int hcf(int a, int b) {
        if(a == 0) {
            return b;
        }
        return hcf(b%a, a);
    }
}
