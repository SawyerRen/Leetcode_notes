package karat.other;

public class Q3 {
    public static boolean isPossibleToReach(int[][] grid, int[] pos) {
        dfs(grid, pos[0], pos[1]);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) return false;
            }
        }
        return true;
    }

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) return;
        grid[i][j] = -1;
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}
