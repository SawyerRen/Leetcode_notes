package frequency.q1200;

import java.util.Arrays;

public class Q1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] time = new int[n][3];
        for (int i = 0; i < n; i++) {
            time[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(time, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        dp[n - 1] = time[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            int end = time[i][1];
            int next = findNext(time, i, end);
            if (next != -1) {
                dp[i] = Math.max(dp[i + 1], time[i][2] + dp[next]);
            } else {
                dp[i] = Math.max(dp[i + 1], time[i][2]);
            }
        }
        return dp[0];
    }

    private int findNext(int[][] time, int start, int end) {
        int left = start + 1, right = time.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (time[mid][0] >= end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left < time.length && time[left][0] >= end ? left : -1;
    }
}
