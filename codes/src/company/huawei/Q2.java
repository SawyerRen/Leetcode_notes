package company.huawei;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
    public static int solution(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] start = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) start = new int[]{i, j};
            }
        }
        queue.add(new int[]{start[0], start[1], 0});
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0], col = poll[1], cost = poll[2];
            if (matrix[row][col] == 3) return cost;
            for (int[] dir : dirs) {
                int x = row + dir[0], y = col + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == 1 || visited[x][y]) continue;
                if (matrix[x][y] == 0) cost += 1;
                else if (matrix[x][y] == 6) {
                    cost += 1;
                    for (int[] d : dirs) {
                        int r = x + d[0], c = y + d[1];
                        if (r >= 0 && r < m && c >= 0 && c <= n && matrix[r][c] == 1) matrix[r][c] = 0;
                    }
                    matrix[x][y] = 0;
                } else if (matrix[x][y] == 4) {
                    cost += 3;
                    matrix[x][y] = 0;
                } else if (matrix[x][y] == 3) return cost + 1;
                queue.add(new int[]{x, y, cost});
                visited[x][y] = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1, 1}, {1, 6, 2, 1}, {1, 1, 0, 1}, {1, 3, 1, 1}};
        System.out.println(solution(arr));
    }
}
