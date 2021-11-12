package company.fbr5.q200;

import java.util.ArrayList;
import java.util.List;

public class Q296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = getRows(grid);
        List<Integer> cols = getCols(grid);
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

    private List<Integer> getCols(int[][] grid) {
        List<Integer> cols = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) cols.add(j);
            }
        }
        return cols;
    }

    private List<Integer> getRows(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) rows.add(i);
            }
        }
        return rows;
    }
}
