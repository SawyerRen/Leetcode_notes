package company.fbr5.other;

import karat.doll.Q1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxOverLappingPoints {
    int maxOverlapping(int[][] intervals, int m) {
        int[] buckets = new int[m * 2 + 1];
        for (int[] interval : intervals) {
            buckets[interval[0] + m]++;
            buckets[interval[0] - m]--;
        }
        int resIndex = -1, count = 0, max = 0;
        for (int i = 0; i < buckets.length; i++) {
            count += buckets[i];
            if (count > max) {
                max = count;
                resIndex = i - m;
            }
        }
        return resIndex;
    }

    int maxOverlapping1(int[][] intervals, int m) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int resIndex = -1, max = 0, index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = -m; i <= m; i++) {
            while (!pq.isEmpty() && i > pq.peek()) {
                pq.poll();
            }
            while (index < intervals.length && intervals[index][0] == i) {
                pq.add(intervals[index++][1]);
            }
            if (max < pq.size()) {
                max = pq.size();
                resIndex = i;
            }
        }
        return resIndex;
    }
}
