package ng2022.oa.amazon.all;

import java.util.Arrays;

public class BetaTesting {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (jobDifficulty.length < d) return -1;
        int[][] dp = new int[n][d + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(dp, jobDifficulty, 0, d);
    }

    private int helper(int[][] dp, int[] jobDifficulty, int i, int d) {
        if (i == jobDifficulty.length && d == 0) return 0;
        if (i == jobDifficulty.length || d == 0) return Integer.MAX_VALUE;
        if (dp[i][d] != -1) return dp[i][d];
        int curMax = jobDifficulty[i];
        int min = Integer.MAX_VALUE;
        for (int j = i; j < jobDifficulty.length; j++) {
            curMax = Math.max(curMax, jobDifficulty[j]);
            int temp = helper(dp, jobDifficulty, j + 1, d - 1);
            if (temp != Integer.MAX_VALUE) {
                min = Math.min(min, curMax + temp);
            }
        }
        dp[i][d] = min;
        return min;
    }
}
