package company.facebook;

import java.util.ArrayList;
import java.util.List;

// 求并集
public class Q986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int m = firstList.length, n = secondList.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);

            if (endMin >= startMax) {
                list.add(new int[]{startMax, endMin});
            }
            if (endMin == firstList[i][1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
