package all_solution.q1100;

import java.util.PriorityQueue;

public class Q1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        int res = 0;
        while (pq.size() > 1) {
            int cost = pq.poll() + pq.poll();
            res += cost;
            pq.add(cost);
        }
        return res;
    }
}
