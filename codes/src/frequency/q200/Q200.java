package frequency.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q200 {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void bfs(char[][] grid, int i, int j, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0];
                int y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') continue;
                queue.add(new int[]{x, y});
                grid[x][y] = '0';
            }
        }
    }
}
