package company.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q253 {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int endIndex = 0;
        int count = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endIndex]) {
                count++;
            } else {
                endIndex++;
            }
        }
        return count;
    }

    public int minMeetingRooms1(int[][] intervals) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int[] interval : intervals) {
            while (!pq.isEmpty() && pq.peek() <= interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
            res = Math.max(res, pq.size());
        }
        return res;
    }
}
