package all_solution.q600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum /= k;
        Map<String, Boolean> map = new HashMap<>();
        return helper(nums, sum, 0, k, new boolean[nums.length], map);
    }

    private boolean helper(int[] nums, int sum, int partSum, int k, boolean[] visited, Map<String, Boolean> map) {
        if (k == 0) return true;
        if (partSum > sum) return false;
        String s = Arrays.toString(visited);
        if (map.containsKey(s)) return map.get(s);
        if (partSum == sum) {
            boolean res = helper(nums, sum, 0, k - 1, visited, map);
            map.put(s, res);
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(nums, sum, partSum + nums[i], k, visited, map)) return true;
            visited[i] = false;
        }
        map.put(s, false);
        return false;
    }
}
