package all_solution.q600;

import java.util.Arrays;

public class Q673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // 以i结尾最大长度的个数
        int[] dp = new int[n];
        // 以i结尾的最大长度
        int[] len = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(len, 1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 == len[i]) {
                        dp[i] += dp[j];
                    } else if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        dp[i] = dp[j];
                    }
                }
            }
            if (len[i] > maxLen) {
                maxLen = len[i];
                count = dp[i];
            } else if (len[i] == maxLen) {
                count += dp[i];
            }
        }
        return count;
    }
}
