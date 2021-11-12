package company.fbr4.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionIntervals {
    static int[][] union(int[][] l1, int[][] l2) {
        if (l1.length == 0) return l2;
        if (l2.length == 0) return l1;
        int[] prev = null;
        int i = 0, j = 0;
        if (l1[0][0] < l2[0][0]) {
            prev = l1[0];
            i++;
        } else {
            prev = l2[0];
            j++;
        }
        List<int[]> list = new ArrayList<>();
        while (i < l1.length || j < l2.length) {
            if (j == l2.length || (i < l1.length && l1[i][0] < l2[j][0])) {
                if (l1[i][0] > prev[1]) {
                    list.add(prev);
                    prev = l1[i];
                } else {
                    prev[1] = Math.max(prev[1], l1[i][1]);
                }
                i++;
            } else if (i == l1.length || (j < l2.length && l1[i][0] >= l2[j][0])) {
                if (l2[j][0] > prev[1]) {
                    list.add(prev);
                    prev = l2[j];
                } else {
                    prev[1] = Math.max(prev[1], l2[j][1]);
                }
                j++;
            }
        }
        list.add(prev);
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] l1 = {{-10, 2}, {4, 10}, {11, 20}};
        int[][] l2 = {{-1, 1}, {3, 9}, {20, 21}, {23, 25}};
        int[][] res = union(l1, l2);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
