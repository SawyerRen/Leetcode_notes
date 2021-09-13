package all_solution.q400;

public class Q474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l + 1][m + 1][n + 1];
        for (int i = 1; i < l + 1; i++) {
            String str = strs[i - 1];
            int ones = 0, zeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else if (c == '1') ones++;
            }
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[l][m][n];
    }
}
