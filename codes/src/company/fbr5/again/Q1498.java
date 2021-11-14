package company.fbr5.again;

import java.util.Arrays;

public class Q1498 {
    public int numSubseq(int[] nums, int target) {
        int mod = (int) 1e9 + 7;
        Arrays.sort(nums);
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1; i < pows.length; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        int left = 0, right = nums.length - 1, res = 0;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                res = (res + pows[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
