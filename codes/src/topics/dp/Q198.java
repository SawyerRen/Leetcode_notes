package topics.dp;

public class Q198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[len] = 0;
        dp[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}
