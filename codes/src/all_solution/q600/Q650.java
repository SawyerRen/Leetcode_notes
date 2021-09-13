package all_solution.q600;

public class Q650 {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            // 需要1次复制和i-1次粘贴
            dp[i] = i;
            for (int j = i / 2; j > 1; j--) {
                // 找到最大的j整除i
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
