package karat.other;

import java.util.ArrayList;
import java.util.List;

public class Q6 {
    List<int[]> find_word_location(char[][] grid, String word) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    List<int[]> list = new ArrayList<>();
                    if (find(grid, i, j, list, 0, new boolean[grid.length][grid[0].length], word)) {
                        return list;
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private boolean find(char[][] grid, int i, int j, List<int[]> list, int index, boolean[][] visited, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] != word.charAt(index)) {
            return false;
        }
        for (int[] dir : dirs) {
            visited[i][j] = true;
            list.add(new int[]{i, j});
            if (find(grid, i + dir[0], j + dir[1], list, index + 1, visited, word)) return true;
            visited[i][j] = false;
            list.remove(list.size() - 1);
        }
        return false;
    }
}
