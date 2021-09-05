package all_solution.q100;

public class Q91 {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int preOne = Integer.parseInt(s.substring(i - 1, i));
            if (0 < preOne) dp[i] += dp[i - 1];
            int preTwo = Integer.parseInt(s.substring(i - 2, i));
            if (10 <= preTwo && preTwo <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
