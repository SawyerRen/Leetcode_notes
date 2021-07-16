package topics.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q253 {
    // 会议按开始时间排序，如果出现一个会议的开始时间比当前会议的最早结束时间还早，就需要增加一个会议室。将会议的结束时间加入
    // 优先队列
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            // 出现比最早结束时间还早开始的会议，res++;
            if (intervals[i][1] < pq.peek()) {
                res++;
            } else {
                pq.poll();
            }
            pq.add(intervals[i][1]);
        }
        return res;
    }
}
