package company.facebook;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(res - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                if (sum > target) {
                    int curDiff = sum - target;
                    if (curDiff < diff) {
                        res = sum;
                        diff = curDiff;
                    }
                    right--;
                } else {
                    int curDiff = target - sum;
                    if (curDiff < diff) {
                        res = sum;
                        diff = curDiff;
                    }
                    left++;
                }
            }
        }
        return res;
    }
}
