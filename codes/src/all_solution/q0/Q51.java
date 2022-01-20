package all_solution.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        int[] rows = new int[n];
        List<List<String>> res = new ArrayList<>();
        helper(res, rows, 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] rows, int i) {
        if (i == rows.length) {
            res.add(toList(rows));
            return;
        }
        for (int index = 0; index < rows.length; index++) {
            rows[i] = index;
            if (valid(rows, i)) {
                helper(res, rows, i + 1);
            }
        }
    }

    private boolean valid(int[] rows, int row) {
        for (int i = 0; i < row; i++) {
            if (rows[i] == rows[row] || Math.abs(i - row) == Math.abs(rows[i] - rows[row])) return false;
        }
        return true;
    }

    private List<String> toList(int[] rows) {
        List<String> res = new ArrayList<>();
        for (int index : rows) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < rows.length; i++) {
                if (i == index) builder.append('Q');
                else builder.append('.');
            }
            res.add(builder.toString());
        }
        return res;
    }
}
