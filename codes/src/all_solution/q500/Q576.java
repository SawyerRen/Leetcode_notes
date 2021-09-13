package all_solution.q500;

import java.util.Arrays;

public class Q576 {
    int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    int mod = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return helper(memo, m, n, maxMove, startRow, startColumn) % mod;
    }

    private int helper(int[][][] memo, int m, int n, int maxMove, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;
        if (maxMove == 0) return 0;
        if (memo[i][j][maxMove] != -1) return memo[i][j][maxMove];
        int count = 0;
        for (int[] dir : dirs) {
            count = (count + helper(memo, m, n, maxMove - 1, i + dir[0], j + dir[1])) % mod;
        }
        count %= mod;
        memo[i][j][maxMove] = count;
        return count;
    }
}
