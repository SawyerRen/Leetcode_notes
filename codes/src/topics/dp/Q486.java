package topics.dp;

public class Q486 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        int firstMax = helper(nums, 0, nums.length - 1, memo);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return firstMax >= sum - firstMax;
    }

    private int helper(int[] nums, int left, int right, int[][] memo) {
        if (left > right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int chooseLeft = nums[left] + Math.min(helper(nums, left + 2, right, memo), helper(nums, left + 1, right - 1, memo));
        int chooseRight = nums[right] + Math.min(helper(nums, left, right - 2, memo), helper(nums, left + 1, right - 1, memo));
        memo[left][right] = Math.max(chooseLeft, chooseRight);
        return memo[left][right];
    }
}
