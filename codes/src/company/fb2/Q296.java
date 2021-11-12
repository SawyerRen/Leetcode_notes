package company.fb2;

import java.util.ArrayList;
import java.util.List;

public class Q296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);
        return minDist(rows) + minDist(cols);
    }

    private int minDist(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        int res = 0;
        while (i < j) {
            res += list.get(j) - list.get(i);
            i++;
            j--;
        }
        return res;
    }

    private List<Integer> getCols(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) res.add(j);
            }
        }
        return res;
    }

    private List<Integer> getRows(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) res.add(i);
            }
        }
        return res;
    }
}
