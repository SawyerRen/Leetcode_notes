package all_solution.q500;

import java.util.Collections;
import java.util.List;

public class Q539 {
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(this::timeDiff);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            int diff = timeDiff(timePoints.get(i + 1), timePoints.get(i));
            if (diff < res) {
                res = diff;
            }
        }
        res = Math.min(res, timeDiff(timePoints.get(0), timePoints.get(timePoints.size() - 1)) + 1440);
        return res;
    }

    private int timeDiff(String a, String b) {
        String[] split1 = a.split(":"), split2 = b.split(":");
        int hour1 = Integer.parseInt(split1[0]);
        int hour2 = Integer.parseInt(split2[0]);
        int min1 = Integer.parseInt(split1[1]);
        int min2 = Integer.parseInt(split2[1]);
        return hour1 * 60 + min1 - (hour2 * 60 + min2);
    }
}
