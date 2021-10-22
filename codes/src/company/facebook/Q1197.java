package company.facebook;

import java.util.*;

public class Q1197 {
    private final int[][] dirs = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Map<String, Integer> memo = new HashMap<>();
        return dfs(memo, x, y);
    }

    private int dfs(Map<String, Integer> memo, int x, int y) {
        String index = x + "," + y;
        if (memo.containsKey(index)) return memo.get(index);
        if (x + y == 0) return 0;
        if (x + y == 2) return 2;
        int res = 1 + Math.min(dfs(memo, x - 2, y - 1), dfs(memo, x - 1, y - 2));
        memo.put(index, res);
        return res;
    }

    public int minKnightMoves1(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == x && poll[1] == y) return level;
                for (int[] dir : dirs) {
                    int row = poll[0] + dir[0];
                    int col = poll[1] + dir[1];
                    if (row < -1 || col < -1 || visited.contains(row + "," + col)) continue;
                    queue.add(new int[]{row, col});
                    visited.add(row + "," + col);
                }
            }
            level++;
        }
        return -1;
    }
}
