package company.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56 {
    // NlogN    logN N
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < intervals.length; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
                end = Math.max(intervals[i + 1][1], end);
                i++;
            }
            list.add(new int[]{start, end});
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
