package topics.dp;

public class Q403 {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int step = stones[i] - stones[j];
                if (step > 0 && step <= n && dp[j][step]) {
                    dp[i][step] = true;
                    if (step > 1) dp[i][step - 1] = true;
                    if (step < n) dp[i][step + 1] = true;
                    if (stones[i] + step == stones[n - 1] || stones[i] + step + 1 == stones[n - 1] || stones[i] + step - 1 == stones[n - 1])
                        return true;
                }
            }
        }
        return false;
    }
}
