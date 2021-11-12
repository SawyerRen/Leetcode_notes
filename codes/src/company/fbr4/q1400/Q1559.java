package company.fbr4.q1400;

public class Q1559 {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (helper(grid, visited, i, j, m, n, -1, -1, grid[i][j])) return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean helper(char[][] grid, boolean[][] visited, int i, int j, int m, int n, int preI, int preJ, char c) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != c) return false;
        if (visited[i][j]) return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x == preI && y == preJ) continue;
            if (helper(grid, visited, x, y, m, n, i, j, c)) return true;
        }
        return false;
    }
}
