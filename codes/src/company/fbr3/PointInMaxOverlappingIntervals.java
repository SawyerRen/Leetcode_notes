package company.fbr3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PointInMaxOverlappingIntervals {
    static int solution1(int[][] intervals, int m) {
        int[] cache = new int[m * 2 + 1];
        for (int[] interval : intervals) {
            cache[interval[0] + m]++;
            cache[interval[1] + m]--;
        }
        int overlap = 0;
        int max = 0, maxIndex = 0;
        for (int i = 0; i < cache.length; i++) {
            overlap += cache[i];
            if (overlap > max) {
                max = overlap;
                maxIndex = i;
            }
        }
        return maxIndex - m;
    }

    static int solution(int[][] intervals, int m) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        int maxSize = 0, maxIndex = 0;
        for (int i = -m; i < m + 1; i++) {
            while (!pq.isEmpty() && pq.peek() < i) pq.poll();
            while (index < intervals.length && intervals[index][0] == i) {
                pq.add(intervals[index++][1]);
            }
            if (pq.size() > maxSize) {
                maxSize = pq.size();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[][] intervals = {{-3, 5}, {0, 2}, {8, 10}, {6, 7}};
        System.out.println(solution1(intervals, 10));
    }
}
