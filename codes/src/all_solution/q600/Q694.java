package all_solution.q600;

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
                    helper(grid, builder, i, j, m, n, 'o');
                    set.add(builder.toString());
                }
            }
        }
        return set.size();
    }

    private void helper(int[][] grid, StringBuilder builder, int i, int j, int m, int n, char d) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        builder.append(d);
        grid[i][j] = 0;
        helper(grid, builder, i + 1, j, m, n, 'd');
        helper(grid, builder, i - 1, j, m, n, 'u');
        helper(grid, builder, i, j + 1, m, n, 'r');
        helper(grid, builder, i, j - 1, m, n, 'l');
        builder.append("b");
    }
}
