package karat.other;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public static List<int[]> findMoves(int[][] grid, int[] pos) {
        List<int[]> res = new ArrayList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int x = pos[0] + dir[0];
            int y = pos[1] + dir[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 0) continue;
            res.add(new int[]{x, y});
        }
        return res;
    }
}
