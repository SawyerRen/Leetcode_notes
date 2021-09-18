package all_solution.q900;

public class Q931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                else if (j == n - 1) dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp[m - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }
}
