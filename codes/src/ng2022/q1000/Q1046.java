package ng2022.q1000;

import java.util.PriorityQueue;

public class Q1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x == y) continue;
            pq.add(x - y);
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
