package all_solution.q800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q827 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = grid.length, n = grid[0].length;
        int color = 2, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, m, n, color);
                    res = Math.max(res, area);
                    map.put(color, area);
                    color++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    Set<Integer> visitedColors = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visitedColors.contains(grid[x][y]))
                            continue;
                        visitedColors.add(grid[x][y]);
                        area += map.get(grid[x][y]);
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, int color) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return 0;
        int area = 1;
        grid[i][j] = color;
        for (int[] dir : dirs) {
            area += dfs(grid, i + dir[0], j + dir[1], m, n, color);
        }
        return area;
    }
}
