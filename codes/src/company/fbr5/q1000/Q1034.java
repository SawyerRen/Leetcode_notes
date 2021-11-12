package company.fbr5.q1000;

public class Q1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int oldColor = grid[row][col];
        dfs(grid, row, col, m, n, oldColor);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -oldColor) grid[i][j] = color;
            }
        }
        return grid;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void dfs(int[][] grid, int row, int col, int m, int n, int oldColor) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != oldColor) return;
        grid[row][col] = -oldColor;
        for (int[] dir : dirs) {
            int x = row + dir[0], y = col + dir[1];
            dfs(grid, x, y, m, n, oldColor);
        }
        if (row > 0 && row < m - 1 && col > 0 && col < n - 1) {
            boolean inside = true;
            for (int[] dir : dirs) {
                int x = row + dir[0], y = col + dir[1];
                if (Math.abs(grid[x][y]) != oldColor) {
                    inside = false;
                    break;
                }
            }
            if (inside) grid[row][col] = oldColor;
        }
    }
}
