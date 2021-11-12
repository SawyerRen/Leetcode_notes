package company.fbr4.again;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Q759 {
    private class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> schedule.get(a[0]).get(a[1]).start));
        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).get(0) != null) {
                pq.add(new int[]{i, 0});
            }
        }
        List<Interval> res = new ArrayList<>();
        int end = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (!pq.isEmpty()) {
            int[] index = pq.poll();
            Interval interval = schedule.get(index[0]).get(index[1]);
            if (interval.start > end) {
                res.add(new Interval(end, interval.start));
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
            if (index[1] < schedule.get(index[0]).size() - 1) {
                pq.add(new int[]{index[0], index[1] + 1});
            }
        }
        return res;
    }
}
