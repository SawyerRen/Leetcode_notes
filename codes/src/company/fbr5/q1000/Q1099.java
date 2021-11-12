package company.fbr5.q1000;

import model.TreeNode;

import java.util.Arrays;

public class Q1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < k) {
                res = Math.max(res, sum);
                i++;
            } else {
                j--;
            }
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}
