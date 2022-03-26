package all_solution.q1000;

import java.util.PriorityQueue;

public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            Integer x = pq.poll();
            Integer y = pq.poll();
            if (x.equals(y)) continue;
            else pq.add(Math.abs(x - y));
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}
