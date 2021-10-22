package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) res++;
                    }
                }
            }
        }
        return res;
    }
}
