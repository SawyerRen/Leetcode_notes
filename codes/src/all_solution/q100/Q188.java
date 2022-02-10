package all_solution.q100;

public class Q188 {
    public int maxProfit(int maxK, int[] prices) {
        int n = prices.length;
        if (maxK >= n / 2) return maxProfit1(prices);
        int[][][] dp = new int[n][2][maxK + 1];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= maxK; k++) {
                if (i == 0) {
                    dp[i][0][k] = 0;
                    dp[i][1][k] = -prices[0];
                } else {
                    dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k] + prices[i]);
                    dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k - 1] - prices[i]);
                }
            }
        }
        return dp[n - 1][0][maxK];
    }

    private int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}
