package topics.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Q354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        List<Integer> heights = new ArrayList<>();
        for (int[] envelope : envelopes) {
            heights.add(envelope[1]);
        }
        return getMaxIncreasingLength(heights);
    }

    private int getMaxIncreasingLength(List<Integer> heights) {
        int res = 0;
        int[] dp = new int[heights.size()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (heights.get(j) < heights.get(i)) {
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
