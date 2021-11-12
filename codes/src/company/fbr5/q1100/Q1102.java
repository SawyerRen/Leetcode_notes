package company.fbr5.q1100;

import java.util.PriorityQueue;

public class Q1102 {
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        boolean[][] visited = new boolean[m][n];
        int res = grid[0][0];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res = Math.min(res, poll[2]);
            if (poll[0] == m - 1 && poll[1] == n - 1) return res;
            for (int[] dir : dirs) {
                int x = dir[0] + poll[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                pq.add(new int[]{x, y, grid[x][y]});
                visited[x][y] = true;
            }
        }
        return -1;
    }
}
