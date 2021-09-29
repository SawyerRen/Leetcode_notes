package karat.other;

import java.util.LinkedList;
import java.util.Queue;

public class Q1 {
    private int[] solution(char[][] grid, int[] start) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int i = poll[0] + dir[0];
                int j = poll[1] + dir[1];
                if (canExit(i, j, m, n)) return new int[]{i, j};
                if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != '0') continue;
                queue.add(new int[]{i, j});
                visited[i][j] = true;
            }
        }
        return new int[]{-1, -1};
    }

    private boolean canExit(int i, int j, int m, int n) {
        return i == 0 || j == 0 || i == m - 1 || j == n - 1;
    }
}
