package company.fb2;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(res - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) return sum;
                if (sum < target) {
                    if (target - sum < minDiff) {
                        res = sum;
                        minDiff = target - sum;
                    }
                    l++;
                } else {
                    if (sum - target < minDiff) {
                        res = sum;
                        minDiff = sum - target;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
