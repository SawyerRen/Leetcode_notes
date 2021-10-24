package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    int total = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            total += num;
        }
        Map<String, Integer> memo = new HashMap<>();
        return helper(memo, nums, target, 0, 0);
    }

    private int helper(Map<String, Integer> memo, int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        String step = i + "," + sum;
        if (memo.containsKey(step)) return memo.get(step);
        int res = 0;
        res += helper(memo, nums, target, sum + nums[i], i + 1);
        res += helper(memo, nums, target, sum - nums[i], i + 1);
        memo.put(step, res);
        return res;
    }
}
