package company.fbr3;

import java.util.LinkedList;
import java.util.Queue;

public class Q317 {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int empty = 0;
        int[][] totalDist = new int[m][n];
        int res = Integer.MAX_VALUE;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Integer.MAX_VALUE;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    int level = 0;
                    while (!queue.isEmpty()) {
                        level++;
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] poll = queue.poll();
                            for (int[] dir : dirs) {
                                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != empty) continue;
                                totalDist[x][y] += level;
                                res = Math.min(totalDist[x][y], res);
                                grid[x][y]--;
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                    empty--;
                }
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
