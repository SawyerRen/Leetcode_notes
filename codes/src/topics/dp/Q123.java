package topics.dp;

public class Q123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxK = 2;
        int[][][] dp = new int[len][maxK + 1][2];
        for (int i = 0; i < len; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        return Math.max(dp[len - 1][maxK][0], dp[len - 1][maxK][1]);
    }
}
