package company.bytedance.oa;

import java.util.Arrays;
import java.util.Comparator;

public class ScheduleShow {
    public int scheduleShow(int[] starts, int[] durations) {
        int[][] shows = new int[starts.length][];
        for (int i = 0; i < shows.length; i++) {
            shows[i] = new int[]{starts[i], durations[i]};
        }
        Arrays.sort(shows, Comparator.comparingInt(a -> a[1]));
        int res = 1;
        int curEnd = shows[0][1];
        for (int[] show : shows) {
            if (show[0] < curEnd) {
                curEnd = Math.max(curEnd, show[1]);
            } else {
                res++;
                curEnd = show[1];
            }
        }
        return res;
    }
}
