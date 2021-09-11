package all_solution.q0;

import java.util.*;

public class Q56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] last = list.get(list.size() - 1);
            if (interval[0] <= last[1]) {
                last[1] = Math.max(last[1], interval[1]);
            } else {
                list.add(interval);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
