package company.facebook.freq;

import java.util.ArrayList;
import java.util.List;

public class Q986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int maxStart = Math.max(firstList[i][0], secondList[j][0]);
            int minEnd = Math.min(firstList[i][1], secondList[j][1]);
            if (maxStart <= minEnd) {
                list.add(new int[]{maxStart, minEnd});
            }
            if (minEnd == firstList[i][1]) i++;
            if (minEnd == secondList[j][1]) j++;
        }
        int[][] res = new int[list.size()][];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
