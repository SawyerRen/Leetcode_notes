package topics.dp;

public class Q115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化 t为空串时，s在任意index都是1种
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 先加上s前一个index处的数量
                dp[i][j] += dp[i - 1][j];
                // 如果当前这个index的字符相同，可以加上前一个index处的数量
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
