package all_solution.q1200;

public class Q1254 {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 0) helper(grid, i, j, m, n);
                }
            }
        }
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    helper(grid, i, j, m, n);
                }
            }
        }
        return res;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void helper(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1) return;
        grid[i][j] = 1;
        for (int[] dir : dirs) {
            helper(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
