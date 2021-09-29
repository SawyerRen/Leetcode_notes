package karat.rectangle;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public List<int[]> findOneRectangle(int[][] board) {
        List<int[]> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    res.add(new int[]{i, j});
                    while (i < m && board[i][j] == 0) {
                        i++;
                    }
                    while (j < n && board[i][j] == 0) {
                        j++;
                    }
                    res.add(new int[]{i - 1, j - 1});
                    return res;
                }
            }
        }
        return res;
    }
}
