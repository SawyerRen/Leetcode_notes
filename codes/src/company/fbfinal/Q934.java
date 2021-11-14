package company.fbfinal;

import java.util.LinkedList;
import java.util.Queue;

public class Q934 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(queue, grid, i, j, m, n);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 2) continue;
                    if (grid[x][y] == 1) return res;
                    queue.add(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
            res++;
        }
        return -1;
    }

    private void dfs(Queue<int[]> queue, int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 2;
        queue.add(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(queue, grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
