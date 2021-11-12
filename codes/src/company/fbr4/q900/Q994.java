package company.fbr4.q900;

import java.util.LinkedList;
import java.util.Queue;

public class Q994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        if (count == 0) return 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
                    queue.add(new int[]{x, y});
                    grid[x][y] = 2;
                    count--;
                }
            }
            res++;
        }
        return count > 0 ? -1 : res - 1;
    }
}
