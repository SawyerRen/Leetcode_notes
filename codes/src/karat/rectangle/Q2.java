package karat.rectangle;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public List<List<int[]>> findMultipleRectangle(int[][] board) {
        List<List<int[]>> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    int row = i, col = j;
                    while (row < m && board[row][col] == 0) {
                        row++;
                    }
                    while (col < n && board[row][col] == 0) {
                        col++;
                    }
                    list.add(new int[]{row - 1, col - 1});
                    for (int r = i; r < row; r++) {
                        for (int c = j; c < col; c++) {
                            board[r][c] = 1;
                        }
                    }
                    res.add(list);
                }
            }
        }
        return res;
    }
}
