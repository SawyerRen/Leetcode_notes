package topics.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q317 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    final int BUILDING = 1;
    final int OBSTACLE = 2;
    final int EMPTY = 0;
    int res = Integer.MAX_VALUE;

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) return res;
        int n = grid[0].length;
        int[][] totalDist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == BUILDING) {
                    bfs(grid, i, j, totalDist, new boolean[m][n]);
                }
            }
        }
        return res;
    }

    private void bfs(int[][] grid, int i, int j, int[][] totalDist, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != EMPTY || visited[i][j])
                        continue;
                    totalDist[x][y] += poll[2] + 1;
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, poll[2] + 1});
                    res = Math.min(res, totalDist[x][y]);
                }
            }
        }
    }
}
