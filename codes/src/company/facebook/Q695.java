package company.facebook;

public class Q695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        int area = 1;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            area += dfs(grid, i + dir[0], j + dir[1]);
        }
        return area;
    }
}
