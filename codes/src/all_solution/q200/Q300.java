package all_solution.q200;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS1(int[] nums) {
        int[] top = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            top[left] = num;
            if (left == size) size++;
        }
        return size;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
