package company.fbr5.q0;

import java.util.ArrayList;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        int[] board = new int[n];
        List<List<String>> res = new ArrayList<>();
        helper(board, res, 0);
        return res;
    }

    private void helper(int[] board, List<List<String>> res, int row) {
        if (row == board.length) {
            res.add(board2String(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            board[row] = col;
            if (valid(board, row)) {
                helper(board, res, row + 1);
            }
        }
    }

    private boolean valid(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(i - row) == Math.abs(board[i] - board[row])) return false;
        }
        return true;
    }

    private List<String> board2String(int[] board) {
        List<String> list = new ArrayList<>();
        for (int i : board) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (i == j) builder.append('Q');
                else builder.append('.');
            }
            list.add(builder.toString());
        }
        return list;
    }
}
