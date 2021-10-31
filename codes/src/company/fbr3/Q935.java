package company.fbr3;

public class Q935 {
    int[][] numbers = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};

    int mod = 1000000007;

    public int knightDialer(int n) {
        int[][] memo = new int[n + 1][10];
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + helper(memo, i, n)) % mod;
        }
        return res;
    }

    private int helper(int[][] memo, int i, int n) {
        if (n == 1) return 1;
        if (memo[n][i] != 0) return memo[n][i];
        int res = 0;
        for (int next : numbers[i]) {
            res = (res + helper(memo, next, n - 1)) % mod;
        }
        memo[n][i] = res;
        return res;
    }
}
