package company.fb2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        boolean even = true;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (even) {
                large.add(num);
                small.add(large.poll());
            } else {
                small.add(num);
                large.add(small.poll());
            }
            even = !even;
        }

        public double findMedian() {
            if (even) {
                return (large.peek() + small.peek()) / 2.0;
            } else {
                return small.peek();
            }
        }
    }
}
