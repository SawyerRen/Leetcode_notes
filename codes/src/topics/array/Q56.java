package topics.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int curIndex = i;
            int start = intervals[i][0], end = intervals[i][1];
            while (i < intervals.length && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            list.add(new int[]{start, end});
            if (curIndex == i) {
                i++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
