package all_solution.q600;

public class Q698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int target = sum / k;
        return helper(nums, k, target, 0, 0, new boolean[nums.length]);
    }

    private boolean helper(int[] nums, int k, int target, int partSum, int start, boolean[] visited) {
        if (k == 0) return true;
        if (partSum > target) return false;
        if (partSum == target) return helper(nums, k - 1, target, 0, 0, visited);
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (helper(nums, k, target, partSum + nums[i], i + 1, visited)) return true;
            visited[i] = false;
        }
        return false;
    }
}
