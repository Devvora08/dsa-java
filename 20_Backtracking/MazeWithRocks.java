// find paths possible from matrix 0,0 to mXn that can have obstructions
// only go Right or Down

// 0    0    0
// 0   rock  0
// 0    0    x  

public class MazeWithRocks {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, false},
            {true, true, true},
            {true, true, true},
        };

        rockPath("", board, 0, 0);
    }

    static void rockPath(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length-1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if(maze[r][c] == false) {
            return;
        } // put a simple if check on specific idx

        if(r < maze.length - 1) {
            rockPath(p + 'D', maze, r + 1, c);
        }

        if(c < maze[0].length - 1) {
            rockPath(p + 'R', maze, r, c + 1);
        }
    }
}
