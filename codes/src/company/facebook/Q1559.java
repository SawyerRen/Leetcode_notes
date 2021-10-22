package company.facebook;

public class Q1559 {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && helper(grid, visited, i, j, -1, -1, m, n, grid[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean helper(char[][] grid, boolean[][] visited, int i, int j, int preI, int preJ, int m, int n, char c) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != c) continue;
            if (x == preI && y == preJ) continue;
            if (visited[x][y]) return true;
            if (helper(grid, visited, x, y, i, j, m, n, c)) return true;
        }
        return false;
    }
}
