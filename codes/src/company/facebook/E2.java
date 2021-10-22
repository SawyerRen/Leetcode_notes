package company.facebook;

import java.util.ArrayList;
import java.util.List;

/*
Given A and B two interval lists, A has no overlap inside A and B has no overlap inside B. Write the function to merge two interval lists, output the result with no overlap. Ask for a very efficient solution

A naive method can combine the two list, and sort and apply merge interval in the leetcode, but is not efficient enough.

For example,
A: [1,5], [10,14], [16,18]
B: [2,6], [8,10], [11,20]

output [1,6], [8, 20]
 */
public class E2 {
    public static int[][] mergeList(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0) return secondList;
        if (secondList.length == 0) return firstList;
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        int[] prev;
        if (firstList[0][0] < secondList[0][0]) {
            prev = firstList[0];
            i++;
        } else {
            prev = secondList[0];
            j++;
        }
        while (i < firstList.length || j < secondList.length) {
            if (j == secondList.length || (i < firstList.length && firstList[i][0] < secondList[j][0])) {
                if (prev[1] < firstList[i][0]) {
                    list.add(prev);
                    prev = firstList[i];
                } else {
                    prev[1] = Math.max(prev[1], firstList[i][1]);
                }
                i++;
            } else {
                if (prev[1] < secondList[j][0]) {
                    list.add(prev);
                    prev = secondList[i];
                } else {
                    prev[1] = Math.max(prev[1], secondList[j][1]);
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

    }
}
