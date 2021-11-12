package company.fbr4.q200;

import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> large;
        PriorityQueue<Integer> small;
        int size = 0;

        public MedianFinder() {
            large = new PriorityQueue<>();
            small = new PriorityQueue<>((a, b) -> b - a);
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
                return (double) (small.peek() + large.peek()) / 2;
            } else {
                return (double) small.peek();
            }
        }
    }
}
