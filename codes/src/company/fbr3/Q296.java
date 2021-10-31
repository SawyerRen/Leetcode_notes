package company.fbr3;

import java.util.ArrayList;
import java.util.List;

public class Q296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        return minDistance(rows) + minDistance(cols);
    }

    private int minDistance(List<Integer> rows) {
        int res = 0;
        int i = 0, j = rows.size() - 1;
        while (i < j) {
            res += rows.get(j) - rows.get(i);
            i++;
            j--;
        }
        return res;
    }

    private List<Integer> collectRows(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    list.add(i);
            }
        }
        return list;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1)
                    list.add(i);
            }
        }
        return list;
    }
}
