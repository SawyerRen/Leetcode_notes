package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q1293 {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][0] = true;
        queue.add(new int[]{0, 0, 0});
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1) return level;
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0];
                    int y = poll[1] + dir[1];
                    int curK = poll[2];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (grid[x][y] == 1) {
                        curK++;
                    }
                    if (curK <= k && !visited[x][y][curK]) {
                        queue.add(new int[]{x, y, curK});
                        visited[x][y][curK] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
