// given a maze of nxm, return number of solutions possible from 0,0 to mxn
// also return the actual path

// only go Right, Down

public class MazeSolutions {
    public static void main(String[] args) {
        //int ans = count(3, 3);
        //System.out.println(ans);

        printPath("", 3, 3);
    }

    static int count(int r, int c) {
        if(r == 1 || c == 1) return 1;

        int down = count(r-1, c);
        int right = count(r, c-1);

        return down+right;
    }

    static void printPath(String p, int r, int c) {
        if(r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        
        if(r > 1) {
            printPath(p + 'D', r-1, c);
        }

        if(c > 1) {
            printPath(p + 'R', r, c-1);
        }

        if(r>1 && c>1) {
            printPath(p + 'd', r-1, c-1);   // d is for diagnol
        }
    }
}
