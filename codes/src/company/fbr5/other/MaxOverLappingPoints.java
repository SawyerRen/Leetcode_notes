package company.fbr5.other;

import karat.doll.Q1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxOverLappingPoints {
    int maxOverlapping(int[][] intervals, int m) {
        int[] count = new int[m * 2 + 1];
        for (int[] interval : intervals) {
            count[interval[0] + m]++;
            count[interval[1] + m]--;
        }
        int resIndex = -1, max = 0, c = 0;
        for (int i = 0; i < count.length; i++) {
            c += count[i];
            if (c > max) {
                max = c;
                resIndex = i - m;
            }
        }
        return resIndex;
    }

    int maxOverlapping1(int[][] intervals, int m) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int resIndex = -1, count = 0, index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = -m; i <= m; i++) {
            while (!pq.isEmpty() && pq.peek() < i) {
                pq.poll();
            }
            while (index < intervals.length && intervals[index][0] == i) {
                pq.add(intervals[index++][1]);
            }
            if (count < pq.size()) {
                count = pq.size();
                resIndex = i;
            }
        }
        return resIndex;
    }


}
