package company.facebook;

import java.util.*;

public class Q1263 {
    public int minPushBox(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int[] target = null, player = null, box = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                } else if (grid[i][j] == 'T') {
                    target = new int[]{i, j};
                } else if (grid[i][j] == 'S') {
                    player = new int[]{i, j};
                }
            }
        }
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<List<Integer>> visited = new HashSet<>();
        queue.add(new int[]{box[0], box[1], player[0], player[1]});
        visited.add(new ArrayList<>(Arrays.asList(box[0], box[1], player[0], player[1])));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                box = new int[]{poll[0], poll[1]};
                player = new int[]{poll[2], poll[3]};
                if (box[0] == target[0] && box[1] == target[1]) return res;
                for (int[] dir : dirs) {
                    int x = box[0] + dir[0], y = box[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '#' ||
                            visited.contains(new ArrayList<>(Arrays.asList(x, y, box[0], box[1]))) ||
                            !canReach(grid, m, n, player, box, new int[]{box[0] - dir[0], box[1] - dir[1]}, dirs))
                        continue;
                    queue.add(new int[]{x, y, box[0], box[1]});
                    visited.add(new ArrayList<>(Arrays.asList(x, y, box[0], box[1])));
                }
            }
            res++;
        }
        return -1;
    }

    private boolean canReach(char[][] grid, int m, int n, int[] player, int[] box, int[] target, int[][] dirs) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(player);
        visited[player[0]][player[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == target[0] && poll[1] == target[1]) return true;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '#' ||
                        (x == box[0] && y == box[1])) continue;
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return false;
    }
}
