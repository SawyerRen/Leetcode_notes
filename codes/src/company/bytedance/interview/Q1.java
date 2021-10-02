package company.bytedance.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.
 */
public class Q1 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int res = 0;
        for (int[] interval : intervals) {
            // interval start time > pq.peek end time
            while (!pq.isEmpty() && interval[0] >= pq.peek()[1]) {
                pq.poll();
            }
            pq.add(interval);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
