package company.fbr5.q200;

import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> b - a);
        int size = 0;

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (size % 2 == 0) {
                large.add(num);
                small.add(large.poll());
            } else {
                small.add(num);
                large.add(small.poll());
            }
            size++;
        }

        public double findMedian() {
            if (size % 2 == 0) {
                return (double) (large.peek() + small.peek()) / 2;
            } else {
                return (double) small.peek();
            }
        }
    }
}
