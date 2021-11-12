package company.fbr4.again;

public class Q1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int oldColor = grid[row][col];
        int m = grid.length, n = grid[0].length;
        dfs(grid, row, col, m, n, oldColor);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -oldColor) grid[i][j] = color;
            }
        }
        return grid;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] grid, int i, int j, int m, int n, int oldColor) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != oldColor) return;
        grid[i][j] = -oldColor;
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], m, n, oldColor);
        }
        if (i > 0 && i < m - 1 && j > 0 && j < n - 1) {
            boolean inside = true;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (Math.abs(grid[x][y]) != oldColor) {
                    inside = false;
                    break;
                }
            }
            if (inside) grid[i][j] = oldColor;
        }
    }
}
