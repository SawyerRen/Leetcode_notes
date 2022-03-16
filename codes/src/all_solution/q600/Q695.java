package all_solution.q600;

public class Q695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, helper(grid, i, j, m, n));
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int helper(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        int area = 1;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            area += helper(grid, i + dir[0], j + dir[1], m, n);
        }
        return area;
    }
}
