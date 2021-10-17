package company.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int res = 0;
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && interval[0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.add(interval);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
