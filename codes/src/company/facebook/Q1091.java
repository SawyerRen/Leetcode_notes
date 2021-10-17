package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1) return dist;
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0];
                    int y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n ||
                            grid[x][y] != 0 || visited[x][y]) continue;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            dist++;
        }
        return -1;
    }
}
