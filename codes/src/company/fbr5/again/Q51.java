package company.fbr5.again;

import java.util.ArrayList;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] board = new int[n];
        helper(res, board, 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] board, int row) {
        if (row == board.length) {
            res.add(b2s(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            board[row] = col;
            if (valid(board, row)) {
                helper(res, board, row + 1);
            }
        }
    }

    private boolean valid(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(i - row) == Math.abs(board[i] - board[row])) return false;
        }
        return true;
    }

    private List<String> b2s(int[] board) {
        List<String> list = new ArrayList<>();
        for (int col : board) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                if (col == i) builder.append('Q');
                else builder.append('.');
            }
            list.add(builder.toString());
        }
        return list;
    }
}
