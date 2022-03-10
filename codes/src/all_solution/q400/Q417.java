package all_solution.q400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] reachA = new boolean[m][n];
        boolean[][] reachP = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, reachP, i, 0, m, n);
            dfs(heights, reachA, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, reachP, 0, j, m, n);
            dfs(heights, reachA, m - 1, j, m, n);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachA[i][j] && reachP[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] heights, boolean[][] reach, int i, int j, int m, int n) {
        reach[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || heights[x][y] < heights[i][j] || reach[x][y]) continue;
            dfs(heights, reach, x, y, m, n);
        }
    }
}
