package company.fbr3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int index = 0;
        while (index < intervals.length && newInterval[0] > intervals[index][1]) {
            list.add(intervals[index++]);
        }
        int start = newInterval[0], end = newInterval[1];
        while (index < intervals.length && end >= intervals[index][0]) {
            start = Math.min(start, intervals[index][0]);
            end = Math.max(end, intervals[index][1]);
            index++;
        }
        list.add(new int[]{start, end});
        while (index < intervals.length) {
            list.add(intervals[index++]);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
