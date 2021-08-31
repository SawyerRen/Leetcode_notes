package topics.dp;

import java.util.Map;

public class Q375 {
    public int getMoneyAmount(int n) {
        int[][] memo = new int[n + 1][n + 1];
        return helper(memo, 1, n);
    }

    private int helper(int[][] memo, int start, int end) {
        if (start >= end) return 0;
        if (memo[start][end] != 0) return memo[start][end];
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            res = Math.min(res, Math.max(helper(memo, start, i - 1), helper(memo, i + 1, end)) + i);
        }
        memo[start][end] = res;
        return res;
    }
}
