package company.facebook;

public class Q494 {
    int total = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            total += num;
        }
        int[][] memo = new int[nums.length][2 * total + 1];
        return helper(memo, nums, target, 0, 0);
    }

    private int helper(int[][] memo, int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            if (target == sum) return 1;
            return 0;
        }
        if (memo[i][sum + total] != 0) return memo[i][sum + total];
        int res = 0;
        res += helper(memo, nums, target, sum + nums[i], i + 1);
        res += helper(memo, nums, target, sum - nums[i], i + 1);
        memo[i][total + sum] = res;
        return res;
    }
}
