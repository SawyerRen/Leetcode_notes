package company.fbr4.q600;

import java.util.HashSet;
import java.util.Set;

public class Q694 {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    dfs(grid, i, j, builder, m, n, 'o');
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder builder, int m, int n, char dir) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) return;
        builder.append(dir);
        grid[i][j] = 0;
        dfs(grid, i + 1, j, builder, m, n, 'd');
        dfs(grid, i - 1, j, builder, m, n, 'u');
        dfs(grid, i, j + 1, builder, m, n, 'r');
        dfs(grid, i, j - 1, builder, m, n, 'l');
        builder.append('b');
    }
}
