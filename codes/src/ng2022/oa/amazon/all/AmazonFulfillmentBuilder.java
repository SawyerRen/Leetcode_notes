package ng2022.oa.amazon.all;

import java.util.PriorityQueue;

public class AmazonFulfillmentBuilder {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        int res = 0;
        while (pq.size() > 1) {
            Integer p1 = pq.poll();
            Integer p2 = pq.poll();
            res += p1 + p2;
            pq.add(p1 + p2);
        }
        return res;
    }
}
