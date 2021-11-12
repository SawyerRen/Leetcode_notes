package company.fbr4.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] reachA = new boolean[m][n];
        boolean[][] reachP = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(reachP, heights, i, 0, m, n);
            dfs(reachA, heights, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(reachP, heights, 0, j, m, n);
            dfs(reachA, heights, m - 1, j, m, n);
        }
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

    private void dfs(boolean[][] reach, int[][] heights, int i, int j, int m, int n) {
        reach[i][j] = true;
        for (int[] dir : dirs) {
            int x = dir[0] + i, y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || heights[x][y] < heights[i][j] || reach[x][y]) continue;
            dfs(reach, heights, x, y, m, n);
        }
    }
}
