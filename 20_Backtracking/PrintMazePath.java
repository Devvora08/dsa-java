// print the maze path, all directions allowed to reach from 0,0 ----> m X n point

import java.util.Arrays;

public class PrintMazePath {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true},
        };
        int[][] path = new int[board.length][board[0].length];
        mazeWithAllDirections("", board, 0, 0, path ,1);
    }

    static void mazeWithAllDirections(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if(r == maze.length-1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for(int[] arr: path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(maze[r][c] == false) {
            return;
        } // put a simple if check on specific idx

        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length - 1) {
            mazeWithAllDirections(p + 'D', maze, r + 1, c, path, step + 1);
        }

        if(c < maze[0].length - 1) {
            mazeWithAllDirections(p + 'R', maze, r, c + 1, path, step + 1);
        }

        if(r > 0) {
            mazeWithAllDirections(p + 'U', maze, r - 1, c, path, step + 1);
        }

        if(c > 0) {
            mazeWithAllDirections(p + 'L', maze, r, c - 1, path, step + 1);
        }

        // function ends here, so before function gets removed, remove the changes set by this version of function
        // so that the previous recursive call doesnt get affected by the changes

        maze[r][c] = true;  // this is what backtracking means
        path[r][c] = 0;
    }
}
