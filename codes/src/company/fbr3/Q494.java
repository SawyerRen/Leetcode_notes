package company.fbr3;

import java.util.HashMap;
import java.util.Map;

public class Q494 {
    Map<String, Integer> map = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    private int helper(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (target == sum) return 1;
            else return 0;
        }
        String state = index + "," + sum;
        if (map.containsKey(state)) return map.get(state);
        int res = 0;
        res += helper(nums, target, index + 1, sum + nums[index]);
        res += helper(nums, target, index + 1, sum - nums[index]);
        map.put(state, res);
        return res;
    }
}
