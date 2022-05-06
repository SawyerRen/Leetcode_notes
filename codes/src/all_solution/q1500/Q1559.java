package all_solution.q1500;

public class Q1559 {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (helper(grid, i, j, visited, -1, -1, m, n)) return true;
            }
        }
        return false;
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean helper(char[][] grid, int i, int j, boolean[][] visited, int preI, int preJ, int m, int n) {
        if (visited[i][j]) return true;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || (x == preI && y == preJ)) continue;
            if (grid[x][y] != grid[i][j]) continue;
            if (helper(grid, x, y, visited, i, j, m, n)) return true;
        }
        return false;
    }
}
