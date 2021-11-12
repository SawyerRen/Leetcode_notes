package company.fb2;

public class Q1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int oldColor = grid[row][col];
        dfs(grid, row, col, oldColor, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -oldColor) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] grid, int row, int col, int oldColor, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != oldColor) return;
        grid[row][col] = -oldColor;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1], oldColor, m, n);
        }
        if (row > 0 && col > 0 && row < m - 1 && col < n - 1) {
            boolean inside = true;
            for (int[] dir : dirs) {
                if (Math.abs(grid[row + dir[0]][col + dir[1]]) != oldColor) {
                    inside = false;
                    break;
                }
            }
            if (inside) grid[row][col] = oldColor;
        }
    }
}
