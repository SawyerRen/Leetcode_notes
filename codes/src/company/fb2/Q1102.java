package company.fb2;

import java.util.PriorityQueue;

public class Q1102 {
    public int maximumMinimumPath(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int m = grid.length, n = grid[0].length;
        int score = grid[0][0];
        pq.add(new int[]{0, 0, grid[0][0]});
        grid[0][0] = -1;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            score = Math.min(score, poll[2]);
            if (poll[0] == m - 1 && poll[1] == n - 1) break;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) continue;
                pq.add(new int[]{x, y, grid[x][y]});
                grid[x][y] = -1;
            }
        }
        return score;
    }
}
