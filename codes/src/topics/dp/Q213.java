package topics.dp;

public class Q213 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        return Math.max(helper(nums, 0, len - 2), helper(nums, 1, len - 1));
    }

    private int helper(int[] nums, int start, int end) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[end + 1] = 0;
        dp[end] = nums[end];
        for (int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }
}
