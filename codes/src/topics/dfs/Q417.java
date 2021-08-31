package topics.dfs;

import java.util.ArrayList;
import java.util.List;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        if (m == 0) return res;
        int n = heights[0].length;

        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, canReachP, i, 0);
            dfs(heights, canReachA, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, canReachP, 0, j);
            dfs(heights, canReachA, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        canReach[i][j] = true;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI < 0 || nextI >= heights.length || nextJ < 0 || nextJ >= heights[0].length ||
                    canReach[nextI][nextJ] || heights[nextI][nextJ] < heights[i][j]) continue;
            dfs(heights, canReach, nextI, nextJ);
        }
    }
}
