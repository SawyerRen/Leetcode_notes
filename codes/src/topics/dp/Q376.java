package topics.dp;

public class Q376 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
