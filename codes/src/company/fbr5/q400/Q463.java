package company.fbr5.q400;

public class Q463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) res++;
                    }
                }
            }
        }
        return res;
    }
}
