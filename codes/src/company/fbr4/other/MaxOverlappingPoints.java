package company.fbr4.other;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxOverlappingPoints {
    static int maxOverlappingPoint(int[][] intervals, int m) {
        int[] bucket = new int[m * 2 + 1];
        for (int[] interval : intervals) {
            bucket[interval[0] + m]++;
            bucket[interval[1] + m]--;
        }
        int res = 0, count = 0, max = 0;
        for (int i = 0; i < 2 * m; i++) {
            count += bucket[i];
            if (count > max) {
                res = i - m;
                max = count;
            }
        }
        return res;
    }

    static int maxOverlappingPoint1(int[][] intervals, int m) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, max = 0, index = 0;
        for (int i = -m; i <= m; i++) {
            while (!pq.isEmpty() && i > pq.peek()) {
                pq.poll();
            }
            while (index < intervals.length && intervals[index][0] == i) {
                pq.add(intervals[index++][1]);
            }
            if (pq.size() > max) {
                max = pq.size();
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{-10, -7}, {-11, -8}, {1, 9}, {-5, -2}, {-6, 7}};
        int i = maxOverlappingPoint(intervals, 11);
        System.out.println(i);
    }
}
