package company.fbr4.q200;

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
        int i = 0, j = list.size() - 1;
        int res = 0;
        while (i < j) {
            res += list.get(j) - list.get(i);
            i++;
            j--;
        }
        return res;
    }

    private List<Integer> getRows(int[][] grid, int m, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) list.add(i);
            }
        }
        return list;
    }

    private List<Integer> getCols(int[][] grid, int m, int n) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) list.add(j);
            }
        }
        return list;
    }
}
