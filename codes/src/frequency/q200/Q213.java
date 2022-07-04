package frequency.q200;

public class Q213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }

    private int helper(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[end] = nums[end];
        for (int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[start];
    }
}
