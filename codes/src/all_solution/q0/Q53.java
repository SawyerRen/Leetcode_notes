package all_solution.q0;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : nums[i] + dp[i - 1];
        }
        int res = nums[0];
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
