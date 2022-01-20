package all_solution.q0;

import java.util.ArrayList;
import java.util.List;

public class Q52 {
    int count = 0;

    public int totalNQueens(int n) {
        int[] rows = new int[n];
        helper(rows, 0);
        return count;
    }

    private void helper(int[] rows, int i) {
        if (i == rows.length) {
            count++;
            return;
        }
        for (int index = 0; index < rows.length; index++) {
            rows[i] = index;
            if (valid(rows, i)) {
                helper(rows, i + 1);
            }
        }
    }

    private boolean valid(int[] rows, int row) {
        for (int i = 0; i < row; i++) {
            if (rows[i] == rows[row] || Math.abs(i - row) == Math.abs(rows[i] - rows[row])) return false;
        }
        return true;
    }
}
