package company.facebook;

import java.util.*;

public class Q827 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int color = 2;
        int m = grid.length, n = grid[0].length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
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
                    Set<Integer> visited = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0 && !visited.contains(grid[x][y])) {
                            area += map.get(grid[x][y]);
                            visited.add(grid[x][y]);
                        }
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, int color) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = color;
        int res = 1;
        for (int[] dir : dirs) {
            res += dfs(grid, i + dir[0], j + dir[1], m, n, color);
        }
        return res;
    }
}
