package karat.rectangle;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<int[]>> findMultipleShapes(int[][] board) {
        List<List<int[]>> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    List<int[]> list = new ArrayList<>();
                    dfs(list, board, i, j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dfs(List<int[]> list, int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 0) return;
        list.add(new int[]{i, j});
        board[i][j] = 1;
        for (int[] dir : dirs) {
            dfs(list, board, i + dir[0], j + dir[1]);
        }
    }
}
