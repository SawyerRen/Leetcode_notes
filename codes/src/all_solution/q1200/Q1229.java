package all_solution.q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (start < end && end - start >= duration) {
                res.add(start);
                res.add(start + duration);
                return res;
            }
            if (end == slots1[i][1]) i++;
            if (end == slots2[j][1]) j++;
        }
        return res;
    }
}
