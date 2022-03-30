package all_solution.q1200;

public class Q1219 {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    res = Math.max(res, helper(grid, i, j, m, n, new boolean[m][n]));
                }
            }
        }
        return res;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int helper(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int res = grid[i][j];
        for (int[] dir : dirs) {
            res = Math.max(res, helper(grid, i + dir[0], j + dir[1], m, n, visited) + grid[i][j]);
        }
        visited[i][j] = false;
        return res;
    }


}
