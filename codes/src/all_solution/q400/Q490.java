package all_solution.q400;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q490 {
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == destination[0] && poll[1] == destination[1]) return true;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (visited[x][y]) continue;
                visited[x][y] = true;
                queue.add(new int[]{x, y});
            }
        }
        return false;
    }
}
