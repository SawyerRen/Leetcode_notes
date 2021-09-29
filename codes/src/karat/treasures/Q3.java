package karat.treasures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q3 {
    public static List<List<int[]>> findShortestPaths(int[][] grid, int[] start, int[] end) {
        List<List<int[]>> res = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        helper(grid, start[0], start[1], end, dirs, new boolean[m][n], new ArrayList<>(), res, count);
        int minDist = Integer.MAX_VALUE;
        for (List<int[]> list : res) {
            minDist = Math.min(minDist, list.size());
        }
        List<List<int[]>> output = new ArrayList<>();
        for (List<int[]> list : res) {
            if (list.size() == minDist) output.add(list);
        }
        return output;
    }

    private static void helper(int[][] grid, int i, int j, int[] end, int[][] dirs, boolean[][] visited, ArrayList<int[]> list, List<List<int[]>> res, int count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == -1) return;
        if (grid[i][j] == 1) {
            count--;
        }
        list.add(new int[]{i, j});
        visited[i][j] = true;
        if (count == 0 && i == end[0] && j == end[1]) {
            res.add(list);
        } else {
            for (int[] dir : dirs) {
                helper(grid, i + dir[0], j + dir[1], end, dirs, visited, list, res, count);

            }
        }
        list.remove(list.size() - 1);
        visited[i][j] = false;
    }
}
