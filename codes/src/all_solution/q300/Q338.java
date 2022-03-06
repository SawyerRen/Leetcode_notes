package all_solution.q300;

public class Q338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) return dp;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i >> 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
