package topics.dp;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }
        int res = nums[0];
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }
}
