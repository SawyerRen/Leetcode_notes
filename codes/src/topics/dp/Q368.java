package topics.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Q368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxCount = 1;
        int maxIndex = 0;
        int maxVal = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxCount) {
                maxCount = dp[i];
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        for (int i = maxIndex; i >= 0; i--) {
            if (maxVal % nums[i] == 0 && dp[i] == maxCount) {
                res.add(nums[i]);
                maxCount--;
                maxVal = nums[i];
            }
        }
        return res;
    }
}
