package company.facebook;

import java.util.Arrays;

public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(res - target);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int num = nums[i] + nums[l] + nums[r];
                if (num == target) return num;
                if (num < target) {
                    if (target - num < diff) {
                        diff = target - num;
                        res = num;
                    }
                    l++;
                } else {
                    if (num - target < diff) {
                        diff = num - target;
                        res = num;
                    }
                    r--;
                }
            }
        }
        return res;
    }
}
