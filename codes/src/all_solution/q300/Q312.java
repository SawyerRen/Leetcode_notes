package all_solution.q300;

import java.util.Arrays;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        Arrays.fill(balloons, 1);
        System.arraycopy(nums, 0, balloons, 1, nums.length);
        int[][] dp = new int[balloons.length][balloons.length];
        for (int len = 2; len <= balloons.length; len++) {
            for (int left = 0; left + len < balloons.length; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][k] + dp[k][right] + balloons[left] * balloons[k] * balloons[right]);
                }
            }
        }
        return dp[0][balloons.length - 1];
    }
}
