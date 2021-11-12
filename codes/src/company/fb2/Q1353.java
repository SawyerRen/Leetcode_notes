package company.fb2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q1353 {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int res = 0;
        int index = 0;
        for (int i = 0; i < 100001; i++) {
            while (!pq.isEmpty() && i > pq.peek()) {
                pq.poll();
            }
            while (index < events.length && events[index][0] == i) {
                pq.add(events[index++][1]);
            }
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        return res;
    }
}
