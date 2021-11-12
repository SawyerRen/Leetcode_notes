package company.fbr5.q1300;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1353 {
    public int maxEvents(int[][] events) {
        int res = 0;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        for (int d = 0; d < 100001; d++) {
            while (!pq.isEmpty() && d > pq.peek()) {
                pq.poll();
            }
            while (index < events.length && events[index][0] == d) {
                pq.add(events[index++][1]);
            }
            if (pq.size() > 0) {
                res++;
                pq.poll();
            }
        }
        return res;
    }
}
