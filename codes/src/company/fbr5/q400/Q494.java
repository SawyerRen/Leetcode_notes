package company.fbr5.q400;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int[][] memo = new int[total * 2 + 1][nums.length];
        return helper(memo, nums, target, 0, 0, total);
    }

    private int helper(int[][] memo, int[] nums, int target, int i, int sum, int total) {
        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        if (memo[total + sum][i] != 0) return memo[total + sum][i];
        int res = 0;
        res += helper(memo, nums, target, i + 1, sum + nums[i], total);
        res += helper(memo, nums, target, i + 1, sum - nums[i], total);
        memo[total + sum][i] = res;
        return res;
    }
}
