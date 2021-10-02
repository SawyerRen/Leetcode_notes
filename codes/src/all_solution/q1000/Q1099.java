package all_solution.q1000;

import java.util.Arrays;

public class Q1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = -1;
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                res = Math.max(res, nums[i] + nums[j]);
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
