package topics.tree;

public class Q96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
