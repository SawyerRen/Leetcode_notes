package company.fbr5.q0;

import java.util.ArrayList;
import java.util.List;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int start = newInterval[0], end = newInterval[1];
        while (i < intervals.length && intervals[i][1] < start) {
            list.add(intervals[i++]);
        }
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
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
