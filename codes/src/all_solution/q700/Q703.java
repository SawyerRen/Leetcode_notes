package all_solution.q700;

import java.util.PriorityQueue;

public class Q703 {

}

class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) pq.poll();
        return pq.peek();
    }
}