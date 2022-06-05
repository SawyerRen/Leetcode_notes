package all_solution.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        helper(res, board, 0);
        return res;
    }

    private void helper(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            res.add(str(board));
        }
        for (int i = 0; i < board.length; i++) {
            if (valid(board, row, i)) {
                board[row][i] = 'Q';
                helper(res, board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q' && (row == i || col == j || (Math.abs(i - row) == Math.abs(j - col))))
                    return false;
            }
        }
        return true;
    }

    private List<String> str(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder builder = new StringBuilder();
            for (char c : row) {
                builder.append(c);
            }
            res.add(builder.toString());
        }
        return res;
    }
}
