package ng2022.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        helper(res, 0, board);
        return res;
    }

    private void helper(List<List<String>> res, int row, char[][] board) {
        if (row == board.length) {
            res.add(toStr(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                helper(res, row + 1, board);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && (i == row || j == col || Math.abs(i - row) == Math.abs(j - col)))
                    return false;
            }
        }
        return true;
    }

    private List<String> toStr(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder builder = new StringBuilder();
            for (char c : row) {
                builder.append(c);
            }
            list.add(builder.toString());
        }
        return list;
    }
}
