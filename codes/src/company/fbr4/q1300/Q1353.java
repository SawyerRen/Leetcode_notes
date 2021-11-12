package company.fbr4.q1300;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0, index = 0, date = 0;
        while (!pq.isEmpty() || index < events.length) {
            if (pq.isEmpty()) {
                date = events[index][0];
            }
            while (index < events.length && events[index][0] <= date) {
                pq.add(events[index++][1]);
            }
            pq.poll();
            res++;
            date++;
            while (!pq.isEmpty() && pq.peek() < date) {
                pq.poll();
            }
        }
        return res;
    }
}
