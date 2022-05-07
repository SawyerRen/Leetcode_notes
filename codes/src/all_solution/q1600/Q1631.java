package all_solution.q1600;

import java.util.LinkedList;
import java.util.Queue;

public class Q1631 {
    public int minimumEffortPath(int[][] heights) {
        int left = 0, right = 1000001;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(heights, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean valid(int[][] heights, int diff) {
        int m = heights.length, n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(heights, 0, 0, m, n, diff, visited);
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean dfs(int[][] heights, int i, int j, int m, int n, int diff, boolean[][] visited) {
        if (i == m - 1 && j == n - 1) return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
            if (Math.abs(heights[x][y] - heights[i][j]) > diff) continue;
            if (dfs(heights, x, y, m, n, diff, visited)) return true;
        }
        return false;
    }
}
