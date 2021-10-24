package company.facebook;

import java.util.Arrays;

public class Q238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left = 1;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
