package all_solution.q900;

import java.util.Arrays;

public class Q935 {
    int[][] nums = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
    int mod = 1000000000 + 7;

    public int knightDialer(int n) {
        int res = 0;
        int[][] memo = new int[n + 1][10];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, i, n)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int i, int n) {
        if (memo[n][i] != -1) return memo[n][i];
        if (n == 1) return 1;
        int res = 0;
        for (int next : nums[i]) {
            res = (res + helper(memo, next, n - 1)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
