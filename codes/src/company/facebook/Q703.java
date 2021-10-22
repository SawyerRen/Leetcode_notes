package company.facebook;

import java.util.PriorityQueue;

public class Q703 {
}

class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k = 0;

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