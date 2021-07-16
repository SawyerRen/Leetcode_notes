package topics.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Q286 {
    // 遍历所有gate，入队列，把gate的周围一圈设为gate+1，再入队列，以此类推进行bfs
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {-1, 0}};
        final int GATE = 0;
        final int EMPTY = Integer.MAX_VALUE;
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == GATE) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0];
                    int y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || rooms[x][y] != EMPTY) continue;
                    rooms[x][y] = dist;
                }
                dist++;
            }
        }
    }
}
