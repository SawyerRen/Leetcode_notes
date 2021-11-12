package company.fb2;

import java.util.Arrays;

public class Q1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, left = 0, right = nums.length - 1, mod = (int) 1e9 + 7;
        int[] pows = new int[nums.length];
        pows[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pows[i] = pows[i - 1] * 2 % mod;
        }
        while (left <= right) {
            if (nums[left] + nums[right] > target) right--;
            else {
                res = (res + pows[right - left]) % mod;
                left++;
            }
        }
        return res;
    }
}
