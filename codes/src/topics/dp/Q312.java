package topics.dp;

import java.util.Arrays;

public class Q312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        System.arraycopy(nums, 0, newNums, 1, n);
        newNums[0] = 1;
        newNums[n + 1] = 1;
        n = newNums.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l < n - len; l++) {
                int r = l + len;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k][r] + newNums[l] * newNums[k] * newNums[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
