package karat.treasures;

public class Q2 {
    public static boolean FindLegalMoves(int[][] grid, int row, int col) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        dfs(grid, row, col, visited, dirs);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) return false;
            }
        }
        return true;
    }

    private static void dfs(int[][] grid, int row, int col, boolean[][] visited, int[][] dirs) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1 || visited[row][col])
            return;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1], visited, dirs);
        }
    }
}
