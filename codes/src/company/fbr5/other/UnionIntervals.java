package company.fbr5.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnionIntervals {
    List<int[]> union(int[][] l1, int[][] l2) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        int[] prev = null;
        if (l1[0][0] < l2[0][0]) {
            prev = l1[0];
            i++;
        } else {
            prev = l2[0];
            j++;
        }
        while (i < l1.length || j < l2.length) {
            if (j == l2.length || (i < l1.length && l1[i][0] < l2[j][0])) {
                if (prev[1] < l1[i][0]) {
                    list.add(prev);
                    prev = l1[i];
                } else {
                    prev[1] = Math.max(prev[1], l1[i][1]);
                }
                i++;
            } else if (i == l1.length || (j < l2.length && l1[i][0] >= l2[j][0])) {
                if (prev[1] < l2[j][0]) {
                    list.add(prev);
                    prev = l2[j];
                } else {
                    prev[1] = Math.max(prev[1], l2[j][1]);
                }
                j++;
            }
        }
        list.add(prev);
        return list;
    }
}
