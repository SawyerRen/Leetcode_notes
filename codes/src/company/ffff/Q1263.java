package company.ffff;

import java.util.*;

public class Q1263 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] player = null, target = null, box = null;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'T') target = new int[]{i, j};
                if (grid[i][j] == 'B') box = new int[]{i, j};
                if (grid[i][j] == 'S') player = new int[]{i, j};
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        queue.add(new int[]{box[0], box[1], player[0], player[1]});
        visited.add(new ArrayList<>(Arrays.asList(box[0], box[1], player[0], player[1])));
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                box = new int[]{poll[0], poll[1]};
                if (box[0] == target[0] && box[1] == target[1]) return res;
                player = new int[]{poll[2], poll[3]};
                for (int[] dir : dirs) {
                    int x = box[0] + dir[0], y = box[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '#' || !reach(grid, box, player, new int[]{box[0] - dir[0], box[1] - dir[1]}) ||
                            visited.contains(Arrays.asList(x, y, box[0], box[1]))) continue;
                    queue.add(new int[]{x, y, box[0], box[1]});
                    visited.add(new ArrayList<>(Arrays.asList(x, y, box[0], box[1])));
                }
            }
            res++;
        }
        return -1;
    }

    private boolean reach(char[][] grid, int[] box, int[] player, int[] target) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(player);
        visited[player[0]][player[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == target[0] && poll[1] == target[1]) return true;
            for (int[] dir : dirs) {
                int x = poll[0] + dir[0], y = poll[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || (x == box[0] && y == box[1]) || grid[x][y] == '#')
                    continue;
                queue.add(new int[]{x, y});
                visited[x][y] = true;
            }
        }
        return false;
    }
}
