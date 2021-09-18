package all_solution.q1000;

public class Q1039 {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len < n; l++) {
                int r = l + len;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + values[l] * values[k] * values[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
