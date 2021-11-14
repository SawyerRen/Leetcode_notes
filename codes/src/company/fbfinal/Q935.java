package company.fbfinal;

public class Q935 {
    int[][] nums = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
    int mod = (int) 1e9 + 7;

    public int knightDialer(int n) {
        int[][] memo = new int[10][n + 1];
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, i, n)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int i, int n) {
        if (n == 1) return 1;
        if (memo[i][n] != 0) return memo[i][n];
        int res = 0;
        for (int next : nums[i]) {
            res = (res + helper(memo, next, n - 1)) % mod;
        }
        memo[i][n] = res;
        return res;
    }
}
