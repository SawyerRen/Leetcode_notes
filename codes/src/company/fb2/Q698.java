package company.fb2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) return false;
        total /= k;
        Map<String, Boolean> map = new HashMap<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return helper(nums, nums.length - 1, 0, 0, k, total, visited, map);
    }

    private boolean helper(int[] nums, int index, int sum, int count, int k, int target, boolean[] visited, Map<String, Boolean> map) {
        if (count == k - 1) return true;
        if (sum > target) return false;
        String s = Arrays.toString(visited);
        if (map.containsKey(s)) return map.get(s);
        if (sum == target) {
            boolean res = helper(nums, nums.length - 1, 0, count + 1, k, target, visited, map);
            map.put(s, res);
            return res;
        }
        for (int j = index; j >= 0; j--) {
            if (visited[j]) continue;
            visited[j] = true;
            if (helper(nums, j - 1, sum + nums[j], count, k, target, visited, map)) {
                return true;
            }
            visited[j] = false;
        }
        map.put(s, false);
        return false;
    }
}
