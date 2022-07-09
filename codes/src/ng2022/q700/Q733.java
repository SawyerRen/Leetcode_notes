package ng2022.q700;

import java.util.LinkedList;
import java.util.Queue;

public class Q733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        int startColor = image[sr][sc];
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            image[poll[0]][poll[1]] = color;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || image[x][y] != startColor) continue;
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return image;
    }
}
