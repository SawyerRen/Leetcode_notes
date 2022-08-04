package ng2022.q0;

public class Q695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int area = dfs(grid, i, j, m, n);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return 0;
        int area = 1;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            area += dfs(grid, i + dir[0], j + dir[1], m, n);
        }
        return area;
    }
}
