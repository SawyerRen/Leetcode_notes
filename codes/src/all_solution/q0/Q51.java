package all_solution.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        int[] board = new int[n];
        List<List<String>> res = new ArrayList<>();
        solve(res, board, 0);
        return res;
    }

    private void solve(List<List<String>> res, int[] board, int row) {
        if (row >= board.length) {
            res.add(getList(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row] = i;
            if (valid(board, row)) {
                solve(res, board, row + 1);
            }
        }
    }

    private boolean valid(int[] board, int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(i - row) == Math.abs(board[i] - board[row])) return false;
        }
        return true;
    }

    private List<String> getList(int[] board) {
        List<String> res = new ArrayList<>();
        for (int index : board) {
            String builder = ".".repeat(Math.max(0, index)) +
                    'Q' +
                    ".".repeat(Math.max(0, board.length - (index + 1)));
            res.add(builder);
        }
        return res;
    }
}
