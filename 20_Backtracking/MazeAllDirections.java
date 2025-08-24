// find paths for matrix mXn from 00, all directions allowed

public class MazeAllDirections {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true},
        };

        mazeWithAllDirections("", board, 0, 0);
    }

    static void mazeWithAllDirections(String p, boolean[][] maze, int r, int c) {
        if(r == maze.length-1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }

        if(maze[r][c] == false) {
            return;
        } // put a simple if check on specific idx

        maze[r][c] = false;

        if(r < maze.length - 1) {
            mazeWithAllDirections(p + 'D', maze, r + 1, c);
        }

        if(c < maze[0].length - 1) {
            mazeWithAllDirections(p + 'R', maze, r, c + 1);
        }

        if(r > 0) {
            mazeWithAllDirections(p + 'U', maze, r - 1, c);
        }

        if(c > 0) {
            mazeWithAllDirections(p + 'L', maze, r, c - 1);
        }

        // function ends here, so before function gets removed, remove the changes set by this version of function
        // so that the previous recursive call doesnt get affected by the changes

        maze[r][c] = true;  // this is what backtracking means
    }
}

// Backtracking is an algorithmic technique for solving problems recursively by attempting to build a solution incrementally,
// one piece at a time. If a partial solution is found to be invalid or unsuitable, the algorithm "backtracks" by undoing the last decision and exploring alternative choices.
// This process continues until a valid solution is found or all possible options have been exhausted. 
