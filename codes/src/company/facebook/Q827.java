package company.facebook;

import java.util.*;

public class Q827 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> areaMap = new HashMap<>();
        int index = 2;
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    areaMap.put(index, dfs(grid, i, j, index));
                    res = Math.max(res, areaMap.get(index));
                    index++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visited = new HashSet<>();
                    List<int[]> neighbors = getNeighbors(grid, i, j);
                    int area = 1;
                    for (int[] neighbor : neighbors) {
                        index = grid[neighbor[0]][neighbor[1]];
                        if (!visited.contains(index) && index > 1) {
                            area += areaMap.get(index);
                            visited.add(index);
                        }



                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private List<int[]> getNeighbors(int[][] grid, int i, int j) {
        List<int[]> list = new ArrayList<>();
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length) {
                list.add(new int[]{nextI, nextJ});
            }
        }
        return list;
    }

    private Integer dfs(int[][] grid, int i, int j, int index) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        int area = 1;
        grid[i][j] = index;
        for (int[] dir : dirs) {
            area += dfs(grid, i + dir[0], j + dir[1], index);
        }
        return area;
    }
}
