package company.fbr3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
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
