package all_solution.q300;

import java.util.Arrays;

public class Q312 {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        Arrays.fill(balloons, 1);
        System.arraycopy(nums, 0, balloons, 1, nums.length);
        int[][] dp = new int[balloons.length][balloons.length];
        for (int len = 2; len <= balloons.length; len++) {
            for (int i = 0; i + len < balloons.length; i++) {
                int right = i + len;
                for (int k = i + 1; k < right; k++) {
                    dp[i][right] = Math.max(dp[i][right], dp[i][k] + dp[k][right] + balloons[i] * balloons[k] * balloons[right]);
                }
            }
        }
        return dp[0][balloons.length - 1];
    }
}
