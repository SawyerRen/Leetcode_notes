package company.fbr4.q400;

import java.util.Arrays;
import java.util.Comparator;

public class Q435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int end = intervals[0][1];
        int count = 1;
        for (int[] interval : intervals) {
            if (end <= interval[0]) {
                end = interval[1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
