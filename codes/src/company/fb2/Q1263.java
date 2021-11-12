package company.fb2;

import java.util.*;

public class Q1263 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] box = null, target = null, player = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') player = new int[]{i, j};
                else if (grid[i][j] == 'B') box = new int[]{i, j};
                else if (grid[i][j] == 'T') target = new int[]{i, j};
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        queue.add(new int[]{box[0], box[1], player[0], player[1]});
        visited.add(Arrays.asList(box[0], box[1], player[0], player[1]));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                box = new int[]{poll[0], poll[1]};
                if (box[0] == target[0] && box[1] == target[1]) return level;
                player = new int[]{poll[2], poll[3]};
                for (int[] dir : dirs) {
                    int x = box[0] + dir[0], y = box[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '#' ||
                            visited.contains(Arrays.asList(x, y, box[0], box[1])) ||
                            !canReach(grid, player, box, new int[]{box[0] - dir[0], box[1] - dir[1]})) continue;
                    queue.add(new int[]{x, y, box[0], box[1]});
                    visited.add(Arrays.asList(x, y, box[0], box[1]));
                }
            }
            level++;
        }
        return -1;
    }

    private boolean canReach(char[][] grid, int[] player, int[] box, int[] target) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(player);
        boolean[][] visited = new boolean[m][n];
        visited[player[0]][player[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == target[0] && poll[1] == target[1]) return true;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == '#'
                        || (box[0] == x && box[1] == y)) continue;
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return false;
    }
}
