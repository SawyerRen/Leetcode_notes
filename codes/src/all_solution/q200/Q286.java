package all_solution.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q286 {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int row = poll[0] + dir[0];
                    int col = poll[1] + dir[1];
                    if (row < 0 || row >= m || col < 0 || col >= n || rooms[row][col] != Integer.MAX_VALUE) {
                        continue;
                    }
                    rooms[row][col] = dist;
                    queue.add(new int[]{row, col});
                }
            }
            dist++;
        }
    }
}
