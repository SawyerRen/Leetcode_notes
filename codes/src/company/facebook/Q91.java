package company.facebook;

public class Q91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        if (s.length() == 0) return 0;
        dp[0] = 1;
        dp[1] = s.charAt(0) > '0' ? 1 : 0;
        for (int i = 2; i < n + 1; i++) {
            int preOne = s.charAt(i - 1) - '0';
            if (preOne > 0) dp[i] += dp[i - 1];
            int preTwo = Integer.parseInt(s.substring(i - 2, i));
            if (10 <= preTwo && preTwo <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
