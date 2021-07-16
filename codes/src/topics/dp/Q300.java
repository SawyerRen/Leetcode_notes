package topics.dp;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
