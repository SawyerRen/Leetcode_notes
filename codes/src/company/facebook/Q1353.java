package company.facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int index = 0;
        for (int d = 1; d < 100001; d++) {
            while (!pq.isEmpty() && d > pq.peek()) pq.poll();
            while (index < events.length && events[index][0] == d) {
                pq.add(events[index][1]);
                index++;
            }
            if (!pq.isEmpty()) {
                res++;
                pq.poll();
            }
        }
        return res;
    }
}
