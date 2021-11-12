package company.fbr5.q1400;

public class Q1559 {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (helper(grid, i, j, m, n, visited, grid[i][j], -1, -1)) return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean helper(char[][] grid, int i, int j, int m, int n, boolean[][] visited, char c, int preI, int preJ) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != c) return false;
        if (visited[i][j]) return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x == preI && y == preJ) continue;
            if (helper(grid, x, y, m, n, visited, c, i, j)) return true;
        }
        return false;
    }
}
