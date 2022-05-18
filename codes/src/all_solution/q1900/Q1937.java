package all_solution.q1900;

public class Q1937 {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            long max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max - 1, dp[i - 1][j]);
                dp[i][j] = max;
            }
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max - 1, dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], max) + points[i][j];
            }
        }
        long res = 0;
        for (long val : dp[m - 1]) {
            res = Math.max(res, val);
        }
        return res;
    }
}
