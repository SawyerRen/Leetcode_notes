package all_solution.q1400;

import java.util.Arrays;

public class Q1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j = nums.length - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int k = 1; k < nums.length; k++) {
            pows[k] = pows[k - 1] * 2 % mod;
        }
        while (i <= j) {
            if (nums[i] + nums[j] > target) j--;
            else {
                res = (res + pows[j - i]) % mod;
                i++;
            }
        }
        return res;
    }
}
