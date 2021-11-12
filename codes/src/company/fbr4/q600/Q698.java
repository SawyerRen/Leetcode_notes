package company.fbr4.q600;

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
        boolean[] visited = new boolean[nums.length];
        Map<String, Boolean> map = new HashMap<>();
        Arrays.sort(nums);
        reverse(nums);
        return helper(map, visited, nums, 0, 0, 0, total, k);
    }

    private boolean helper(Map<String, Boolean> map, boolean[] visited, int[] nums, int index, int count, int sum, int target, int k) {
        if (count == k - 1) return true;
        if (sum > target) return false;
        String s = Arrays.toString(visited);
        if (map.containsKey(s)) return map.get(s);
        if (sum == target) {
            boolean res = helper(map, visited, nums, 0, count + 1, 0, target, k);
            map.put(s, res);
            return res;
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(map, visited, nums, i + 1, count, sum + nums[i], target, k))
                return true;
            visited[i] = false;
        }
        map.put(s, false);
        return false;
    }

    private void reverse(int[] nums) {
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
