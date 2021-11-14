package company.fbr5.again;

public class Q494 {
    int total = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            total += num;
        }
        int[][] memo = new int[total * 2 + 1][nums.length];
        return helper(memo, nums, target, 0, 0);
    }

    private int helper(int[][] memo, int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        if (memo[total + sum][index] != 0) return memo[total + sum][index];
        int res = 0;
        res += helper(memo, nums, target, index + 1, sum + nums[index]);
        res += helper(memo, nums, target, index + 1, sum - nums[index]);
        memo[total + sum][index] = res;
        return res;
    }
}
