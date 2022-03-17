package all_solution.q700;

import java.util.LinkedList;
import java.util.Queue;

public class Q733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            image[poll[0]][poll[1]] = newColor;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oldColor) continue;
                queue.add(new int[]{x, y});
            }
        }
        return image;
    }
}
