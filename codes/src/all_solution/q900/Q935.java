package all_solution.q900;

import java.util.Arrays;

public class Q935 {
    int[][] nums = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
    int mod = 1000000000 + 7;

    public int knightDialer(int n) {
        int[][] memo = new int[n + 1][10];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, n, i)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int n, int i) {
        if (n == 1) return 1;
        if (memo[n][i] != -1) return memo[n][i];
        int res = 0;
        for (int next : nums[i]) {
            res = (res + helper(memo, n - 1, next)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
