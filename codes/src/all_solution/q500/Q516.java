package all_solution.q500;

public class Q516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int right = 1; right < n; right++) {
            for (int left = right - 1; left >= 0; left--) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (left == right - 1) {
                        dp[left][right] = 2;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1] + 2;
                    }
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
