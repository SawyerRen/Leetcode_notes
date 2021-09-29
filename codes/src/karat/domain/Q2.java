package karat.domain;

public class Q2 {
    public static String[] LCS(String[] s1, String[] s2) {
        int m = s1.length, n = s2.length;
        int max = 0;
        int left = -1;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1[i - 1].equals(s2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        left = i - max;
                    }
                }
            }
        }
        if (max == 0) return new String[0];
        String[] res = new String[max];
        for (int i = 0; i < max; i++) {
            res[i] = s1[left++];
        }
        return res;
    }
}
