package company.fbr3;

import model.ListNode;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalUnion {
    static public List<int[]> solution(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int[] prev = null;
        if (firstList[0][0] < secondList[0][0]) {
            prev = firstList[0];
            i++;
        } else {
            prev = secondList[0];
            j++;
        }
        while (i < firstList.length || j < secondList.length) {
            if (j == secondList.length || (i < firstList.length && firstList[i][0] < secondList[j][0])) {
                if (firstList[i][0] > prev[1]) {
                    res.add(prev);
                    prev = firstList[i];
                } else {
                    prev[1] = Math.max(prev[1], firstList[i][1]);
                }
                i++;
            } else if (i == firstList.length || firstList[i][0] >= secondList[j][0]) {
                if (secondList[j][0] > prev[1]) {
                    res.add(prev);
                    prev = secondList[j];
                } else {
                    prev[1] = Math.max(prev[1], secondList[j][1]);
                }
                j++;
            }
        }
        res.add(prev);
        return res;
    }

    public static void main(String[] args) {
        int[][] l1 = {{-1, 0}, {1, 3}, {4, 10}};
        int[][] l2 = {{-2, -1}, {7, 12}};
        List<int[]> solution = solution(l1, l2);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
