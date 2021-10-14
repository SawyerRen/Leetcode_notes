package company.facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Q317 {
    public int shortestDistance(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        int[][] totalDist = new int[m][n];
        int res = Integer.MAX_VALUE;
        int emptyVal = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Integer.MAX_VALUE;
                    int dist = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        dist++;
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int[] poll = queue.poll();
                            for (int[] dir : dirs) {
                                int nextRow = poll[0] + dir[0];
                                int nextCol = poll[1] + dir[1];
                                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || grid[nextRow][nextCol] != emptyVal) {
                                    continue;
                                }
                                totalDist[nextRow][nextCol] += dist;
                                res = Math.min(res, totalDist[nextRow][nextCol]);
                                queue.add(new int[]{nextRow, nextCol});
                                grid[nextRow][nextCol]--;
                            }
                        }
                    }
                    emptyVal--;
                }
            }
        }
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }
}
