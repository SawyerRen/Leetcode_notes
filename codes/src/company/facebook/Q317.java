package company.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Q317 {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] totalDist = new int[m][n];
        int empty = 0;
        int res = Integer.MAX_VALUE;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Integer.MAX_VALUE;
                    int level = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        level++;
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] poll = queue.poll();
                            for (int[] dir : dirs) {
                                int x = dir[0] + poll[0];
                                int y = dir[1] + poll[1];
                                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != empty) continue;
                                totalDist[x][y] += level;
                                res = Math.min(res, totalDist[x][y]);
                                queue.add(new int[]{x, y});
                                grid[x][y]--;
                            }
                        }
                    }
                    empty--;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
