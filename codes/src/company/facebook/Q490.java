package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == destination[0] && poll[1] == destination[1]) return true;
            for (int[] dir : dirs) {
                int x = dir[0] + poll[0];
                int y = dir[1] + poll[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (!visited[x][y]) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}
