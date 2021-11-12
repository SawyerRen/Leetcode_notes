package company.fbr4.q1000;

import java.util.Arrays;

public class Q1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < k) {
                res = Math.max(res, sum);
                l++;
            } else {
                r--;
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
