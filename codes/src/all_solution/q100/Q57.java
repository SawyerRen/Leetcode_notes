package all_solution.q100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int index = 0;
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            list.add(intervals[index]);
            index++;
        }
        int start = newInterval[0], end = newInterval[1];
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            start = Math.min(intervals[index][0], start);
            end = Math.max(intervals[index][1], end);
            index++;
        }
        list.add(new int[]{start, end});
        while (index < intervals.length) {
            list.add(intervals[index++]);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
