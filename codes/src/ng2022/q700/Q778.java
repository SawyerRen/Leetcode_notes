package ng2022.q700;

import java.util.LinkedList;
import java.util.Queue;

public class Q778 {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = 0, right = n * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSwim(grid, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canSwim(int[][] grid, int mid) {
        int n = grid.length;
        if (grid[0][0] > mid || grid[n - 1][n - 1] > mid) return false;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == n - 1 && poll[1] == n - 1) return true;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] > mid) continue;
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return false;
    }
}
