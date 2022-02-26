package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q296 {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> rows = getRows(grid, m, n);
        List<Integer> cols = getCols(grid, m, n);
        return getDist(rows) + getDist(cols);
    }

    private int getDist(List<Integer> list) {
        int res = 0;
        int i = 0, j = list.size() - 1;
        while (i < j) {
            res += list.get(j) - list.get(i);
            i++;
            j--;
        }
        return res;
    }

    private List<Integer> getCols(int[][] grid, int m, int n) {
        List<Integer> cols = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) cols.add(j);
            }
        }
        return cols;
    }

    private List<Integer> getRows(int[][] grid, int m, int n) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) rows.add(i);
            }
        }
        return rows;
    }
}
