package company.fbr5.q600;

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
                    helper(grid, i, j, m, n, builder, 'o');
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    private void helper(int[][] grid, int i, int j, int m, int n, StringBuilder builder, char dir) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1) return;
        builder.append(dir);
        grid[i][j] = 0;
        helper(grid, i + 1, j, m, n, builder, 'd');
        helper(grid, i - 1, j, m, n, builder, 'u');
        helper(grid, i, j + 1, m, n, builder, 'r');
        helper(grid, i, j - 1, m, n, builder, 'l');
        builder.append('b');
    }
}
