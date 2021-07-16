package topics.dp;

public class Q276 {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[n - 2] * (k - 1);
        }
        return dp[n];
    }
}
