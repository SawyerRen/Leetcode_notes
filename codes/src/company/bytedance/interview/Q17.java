package company.bytedance.interview;

public class Q17 {
    int combineRopes(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0) return 0;
        sum /= 2;
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][sum] ? 1 : 0;
    }
}
