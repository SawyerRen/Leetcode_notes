package all_solution.q400;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target < -sum || target > sum) return 0;
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j - nums[i - 1] >= 0) dp[i][j] += dp[i - 1][j - nums[i - 1]];
                if (j + nums[i - 1] <= 2 * sum) dp[i][j] += dp[i - 1][j + nums[i - 1]];
            }
        }
        return dp[nums.length][sum + target];
    }

    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays1(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    private int helper(int[] nums, int target, int i, int num) {
        if (i == nums.length) {
            if (num == target) return 1;
            return 0;
        }
        String state = i + "," + num;
        if (memo.containsKey(state)) return memo.get(state);
        int count = helper(nums, target, i + 1, num + nums[i]) + helper(nums, target, i + 1, num - nums[i]);
        memo.put(state, count);
        return count;
    }
}
