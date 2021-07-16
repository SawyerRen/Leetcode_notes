package topics.dp;

public class Q188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return maxProfitWithoutK(prices);
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return Math.max(dp[len - 1][k][0], dp[len - 1][k][1]);
    }

    private int maxProfitWithoutK(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        }
        return res;
    }
}
