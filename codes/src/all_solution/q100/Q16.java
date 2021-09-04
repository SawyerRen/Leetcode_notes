package all_solution.q100;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(res - target);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                int diff = Math.abs(sum - target);
                if (diff < minDiff) {
                    res = sum;
                    minDiff = diff;
                }
                if (sum < target) left++;
                else right--;
            }
        }
        return res;
    }
}
