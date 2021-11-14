package company.fbr5.again;

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
        Arrays.sort(nums);
        reverse(nums);
        boolean[] visited = new boolean[nums.length];
        Map<String, Boolean> map = new HashMap<>();
        return helper(map, nums, visited, k, total, 0, 0, 0);
    }

    private boolean helper(Map<String, Boolean> map, int[] nums, boolean[] visited, int k, int target, int sum, int count, int index) {
        if (count == k - 1) return true;
        if (sum > target) return false;
        String s = Arrays.toString(visited);
        if (map.containsKey(s)) return map.get(s);
        if (sum == target) {
            boolean res = helper(map, nums, visited, k, target, 0, count + 1, 0);
            map.put(s, res);
            return res;
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(map, nums, visited, k, target, sum + nums[i], count, i + 1)) return true;
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
