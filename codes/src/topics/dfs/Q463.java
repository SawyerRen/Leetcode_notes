package topics.dfs;

public class Q463 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int res = 0;

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return res;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = -1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length || grid[nextI][nextJ] == 0) {
                res++;
                continue;
            }
            dfs(grid, nextI, nextJ);
        }
    }
}
