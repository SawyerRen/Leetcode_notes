package ng2022.oa.amazon.all;

import java.util.List;
import java.util.PriorityQueue;

public class FindTheHighestProfit {
    public static int findProfit(List<Integer> inventory, int order) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(inventory);
        int res = 0;
        for (int i = 0; i < order; i++) {
            Integer poll = pq.poll();
            res += poll;
            pq.add(poll - 1);
        }
        return res;
    }
}
