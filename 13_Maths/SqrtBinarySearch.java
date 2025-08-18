public class SqrtBinarySearch {
    public static void main(String[] args) {
        int n = 40;
        int precision = 3;

        System.out.println(sqrt(n, precision));
    }

    static double sqrt(int n, int p) {
        int start = 0;
        int end = n;
        double root = 0.0;

        // Binary search for integer part
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == n) {
                return mid;
            }
            if (mid * mid < n) {
                root = mid; // store best guess
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // For precision
        double increment = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= n) {
                root += increment;
            }
            root -= increment; // go back one step after overshooting
            increment /= 10;
        }

        // Round to 'p' decimal places
        return Math.round(root * Math.pow(10, p)) / Math.pow(10, p);
    }
}
