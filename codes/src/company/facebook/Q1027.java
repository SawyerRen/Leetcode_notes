package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}
