package company.fbr5.q400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] reachA = new boolean[m][n];
        boolean[][] reachP = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, reachP, m, n);
            dfs(heights, i, n - 1, reachA, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, reachP, m, n);
            dfs(heights, m - 1, j, reachA, m, n);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachA[i][j] && reachP[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] heights, int i, int j, boolean[][] reachP, int m, int n) {
        reachP[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || reachP[x][y] || heights[i][j] > heights[x][y]) continue;
            dfs(heights, x, y, reachP, m, n);
        }
    }
}
