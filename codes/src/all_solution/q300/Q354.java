package all_solution.q300;

import java.util.Arrays;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = envelopes[i][1];
        }
        return helper(heights);
    }

    private int helper(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        int len = 0;
        for (int height : heights) {
            int i = Arrays.binarySearch(dp, 0, len, height);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = height;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
