package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1) return -1;
        queue.add(new int[]{0, 0});
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1) return level;
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] != 0) continue;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }
}
