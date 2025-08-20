// formate patterns using recursion

public class PatternsRecursion {
    public static void main(String[] args) {
        trianglePattern2(4, 0);
    }

    static void trianglePattern(int r, int c) {
        if (r == 0)
            return;
        if (c < r) {
            System.out.print(" * ");
            trianglePattern(r, c + 1);
        } else {
            System.out.println();
            trianglePattern(r - 1, 0);
        }
    }

    static void trianglePattern2(int r, int c) {
        if (r == 0)
            return;
        if (c < r) {
            trianglePattern2(r, c + 1);
            System.out.print(" * ");
        } else {
            trianglePattern2(r - 1, 0);
            System.out.println();
        }
    }
}
