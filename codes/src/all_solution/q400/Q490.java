package all_solution.q400;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q490 {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (Arrays.equals(poll, destination)) return true;
            for (int[] dir : dirs) {
                int row = poll[0], col = poll[1];
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                while (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && maze[nextRow][nextCol] != 1) {
                    row = nextRow;
                    col = nextCol;
                    nextRow += dir[0];
                    nextCol += dir[1];
                }
                if (visited[row][col]) continue;
                queue.add(new int[]{row, col});
                visited[row][col] = true;
            }
        }
        return false;
    }

    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        return helper(maze, start[0], start[1], destination, new boolean[maze.length][maze[0].length]);
    }

    private boolean helper(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (visited[i][j]) return false;
        if (i == destination[0] && j == destination[1]) return true;
        visited[i][j] = true;
        for (int index = 0; index < 4; index++) {
            int row = i, col = j;
            int nextRow = row + dirs[index][0];
            int nextCol = col + dirs[index][1];
            while (nextRow >= 0 && nextRow < maze.length && nextCol >= 0 && nextCol < maze[0].length && maze[nextRow][nextCol] != 1) {
                row = nextRow;
                col = nextCol;
                nextRow = row + dirs[index][0];
                nextCol = col + dirs[index][1];
            }
            if (helper(maze, row, col, destination, visited)) return true;
        }
        return false;
    }
}
