package all_solution.q500;

import java.util.Collections;
import java.util.List;

public class Q539 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] marked = new boolean[24 * 60];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int h = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int time = h * 60 + m;
            min = Math.min(min, time);
            max = Math.max(max, time);
            if (marked[time]) return 0;
            marked[time] = true;
        }
        int res = Integer.MAX_VALUE, pre = -1;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) {
            if (marked[i]) {
                if (pre != -1) {
                    res = Math.min(res, i - pre);
                }
                pre = i;
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        res = Math.min(res, first - last + 24 * 60);
        return res;
    }
}
