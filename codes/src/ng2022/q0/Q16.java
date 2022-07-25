package ng2022.q0;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(res - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                if (sum < target) {
                    if (target - sum < minDiff) {
                        minDiff = target - sum;
                        res = sum;
                    }
                    left++;
                } else {
                    if (sum - target < minDiff) {
                        minDiff = sum - target;
                        res = sum;
                    }
                    right--;
                }
            }
        }
        return res;
    }
}
