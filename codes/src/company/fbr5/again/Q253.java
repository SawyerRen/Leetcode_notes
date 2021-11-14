package company.fbr5.again;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(interval[1]);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
