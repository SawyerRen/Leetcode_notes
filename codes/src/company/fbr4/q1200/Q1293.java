package company.fbr4.q1200;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1293 {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == m - 1 && poll[1] == n - 1) return res;
                for (int[] dir : dirs) {
                    int curK = poll[2];
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (grid[x][y] == 1) curK++;
                    if (curK > k || visited[x][y][curK]) continue;
                    queue.add(new int[]{x, y, curK});
                    visited[x][y][curK] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
