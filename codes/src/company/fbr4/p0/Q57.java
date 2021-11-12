package company.fbr4.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        int start = newInterval[0], end = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        list.add(new int[]{start, end});
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
