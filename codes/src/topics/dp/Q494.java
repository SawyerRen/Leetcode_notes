package topics.dp;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target > sum || target < -sum) return 0;
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
                if (j + nums[i - 1] <= 2 * sum) dp[i][j] += dp[i - 1][j + nums[i - 1]];
            }
        }
        return dp[nums.length][sum + target];
    }
}
