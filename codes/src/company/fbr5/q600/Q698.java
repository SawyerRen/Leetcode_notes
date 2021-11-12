package company.fbr5.q600;

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
        Arrays.sort(nums);
        reverse(nums);
        boolean[] visited = new boolean[nums.length];
        Map<String, Boolean> map = new HashMap<>();
        return helper(map, nums, k, total / k, 0, 0, 0, visited);
    }

    private boolean helper(Map<String, Boolean> map, int[] nums, int k, int target, int count, int index, int sum, boolean[] visited) {
        if (count == k - 1) return true;
        if (sum > target) return false;
        String s = Arrays.toString(visited);
        if (map.containsKey(s)) return map.get(s);
        if (sum == target) {
            boolean res = helper(map, nums, k, target, count + 1, 0, 0, visited);
            map.put(s, res);
            return res;
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(map, nums, k, target, count, i + 1, sum + nums[i], visited)) return true;
            visited[i] = false;
        }
        map.put(s, false);
        return false;
    }

    void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}
