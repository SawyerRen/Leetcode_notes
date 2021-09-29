package karat.treasures;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public static List<int[]> findLegalMoves(int i, int j, int[][] grid) {
        List<int[]> res = new ArrayList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 0) continue;
            res.add(new int[]{row, col});
        }
        return res;
    }
}
