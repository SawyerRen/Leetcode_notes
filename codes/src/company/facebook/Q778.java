package company.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q778 {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int left = 0, right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (helper(grid, m, n, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean helper(int[][] grid, int m, int n, int mid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        if (grid[0][0] > mid) return false;
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == m - 1 && poll[1] == n - 1) return true;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] > mid) {
                    continue;
                }
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return false;
    }
}
