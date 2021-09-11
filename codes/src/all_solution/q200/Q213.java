package all_solution.q200;

public class Q213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int rob1 = rob(nums, 0, n - 2);
        int rob2 = rob(nums, 1, n - 1);
        return Math.max(rob1, rob2);
    }

    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 1];
        dp[end] = nums[end];
        dp[end + 1] = 0;
        for (int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[start];
    }
}
