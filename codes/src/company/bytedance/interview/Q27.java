package company.bytedance.interview;

import java.util.ArrayList;
import java.util.List;

/*
51. N-Queens
 */
public class Q27 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] board = new int[n];
        helper(res, board, 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] board, int row) {
        if (row >= board.length) {
            res.add(toList(board));
        }
        for (int i = 0; i < board.length; i++) {
            if (valid(board, row, i)) {
                board[row] = i;
                helper(res, board, row + 1);
            }
        }
    }

    private boolean valid(int[] board, int row, int index) {
        for (int i = 0; i < row; i++) {
            if (index == board[i] || Math.abs(row - i) == Math.abs(index - board[i])) return false;
        }
        return true;
    }

    private List<String> toList(int[] board) {
        List<String> res = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                if (i == board[row]) builder.append("Q");
                else builder.append(".");
            }
            res.add(builder.toString());
        }
        return res;
    }
}
