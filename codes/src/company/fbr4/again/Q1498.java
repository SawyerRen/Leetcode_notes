package company.fbr4.again;

import java.util.Arrays;

public class Q1498 {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int res = 0, mod = (int) 1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = (pows[i - 1] * 2) % mod;
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                res = (res + pows[j - i]) % mod;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
