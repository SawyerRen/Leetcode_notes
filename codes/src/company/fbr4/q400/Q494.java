package company.fbr4.q400;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return helper(map, nums, 0, 0, target);
    }

    private int helper(Map<String, Integer> map, int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            if (sum == target) return 1;
            else return 0;
        }
        String state = i + "," + sum;
        if (map.containsKey(state)) return map.get(state);
        int res = 0;
        res += helper(map, nums, i + 1, sum + nums[i], target);
        res += helper(map, nums, i + 1, sum - nums[i], target);
        map.put(state, res);
        return res;
    }
}
