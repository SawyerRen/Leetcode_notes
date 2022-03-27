package all_solution.q1100;

import java.util.PriorityQueue;

public class Q1102 {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
        pq.add(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res = Math.min(res, grid[poll[0]][poll[1]]);
            if (poll[0] == m - 1 && poll[1] == n - 1) {
                return res;
            }
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                visited[x][y] = true;
                pq.add(new int[]{x, y});
            }
        }
        return res;
    }
}
