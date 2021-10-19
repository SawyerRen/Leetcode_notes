package company.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q778 {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(grid, mid, new boolean[n][n], 0, 0)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean valid(int[][] grid, int mid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n ||
                grid[i][j] > mid || visited[i][j]) return false;
        if (i == n - 1 && j == n - 1) return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (valid(grid, mid, visited, x, y)) return true;
        }
        return false;
    }
}
