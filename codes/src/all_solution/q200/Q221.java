package all_solution.q200;

public class Q221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                res = 1;
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                res = 1;
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res * res;
    }
}
