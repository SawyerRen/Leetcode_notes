package company.fbr3;

import java.util.Arrays;

public class Q435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int res = 1;
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                res++;
                end = interval[1];
            }
        }
        return intervals.length - res;
    }
}
