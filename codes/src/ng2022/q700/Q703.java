package ng2022.q700;

import java.util.PriorityQueue;

public class Q703 {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            for (int num : nums) {
                pq.add(num);
                if (pq.size() > k) pq.poll();
            }
            this.k = k;
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }
}
