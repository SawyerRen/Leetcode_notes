package topics.array;

import java.util.ArrayList;
import java.util.List;

public class Q296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rowIndexList = getRowIndexList(grid);
        List<Integer> colIndexList = getColIndexList(grid);
        return getDist(rowIndexList) + getDist(colIndexList);
    }

    private int getDist(List<Integer> indexList) {
        int dist = 0;
        int left = 0, right = indexList.size() - 1;
        while (left < right) {
            dist += indexList.get(right) - indexList.get(left);
            right--;
            left++;
        }
        return dist;
    }

    private List<Integer> getRowIndexList(int[][] grid) {
        List<Integer> rowIndexList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) rowIndexList.add(i);
            }
        }
        return rowIndexList;
    }

    private List<Integer> getColIndexList(int[][] grid) {
        List<Integer> colIndexList = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) colIndexList.add(j);
            }
        }
        return colIndexList;
    }
}
