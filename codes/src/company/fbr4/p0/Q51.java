package company.fbr4.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, board, n, 0);
        return res;
    }

    private void helper(List<List<String>> res, char[][] board, int n, int row) {
        if (row == n) {
            res.add(toS(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (valid(board, row, col, n)) {
                board[row][col] = 'Q';
                helper(res, board, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q' && (row == i || col == j || Math.abs(i - row) == Math.abs(j - col))) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> toS(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                builder.append(board[i][j]);
            }
            list.add(builder.toString());
        }
        return list;
    }
}
