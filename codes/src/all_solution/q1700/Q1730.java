package all_solution.q1700;

import java.util.LinkedList;
import java.util.Queue;

public class Q1730 {
    public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] start = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    start = new int[]{i, j};
                    queue.add(start);
                    visited[i][j] = true;
                    break;
                }
            }
            if (start != null) break;
        }
        int res = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (grid[poll[0]][poll[1]] == '#') return res;
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 'X') continue;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
