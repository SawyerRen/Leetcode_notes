package company.fbr4.q900;

import java.util.ArrayList;
import java.util.List;

public class Q986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int maxStart = Math.max(firstList[i][0], secondList[j][0]);
            int minEnd = Math.min(firstList[i][1], secondList[j][1]);
            if (maxStart <= minEnd) list.add(new int[]{maxStart, minEnd});
            if (firstList[i][1] == minEnd) i++;
            if (secondList[j][1] == minEnd) j++;
        }
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
