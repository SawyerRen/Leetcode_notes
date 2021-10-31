package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return helper(map, nums, target, 0, 0);
    }

    private int helper(Map<String, Integer> map, int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }
        String state = i + "," + sum;
        if (map.containsKey(state)) return map.get(state);
        int res = 0;
        res += helper(map, nums, target, i + 1, sum + nums[i]);
        res += helper(map, nums, target, i + 1, sum - nums[i]);
        map.put(state, res);
        return res;
    }
}
