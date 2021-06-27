package topics.dp;

import java.util.Map;

public class Q152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(nums[i], Math.max(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
            dp[i][1] = Math.min(nums[i], Math.min(nums[i] * dp[i - 1][0], nums[i] * dp[i - 1][1]));
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
}
