package frequency.q200;

import java.util.PriorityQueue;

public class Q295 {
    class MedianFinder {
        PriorityQueue<Integer> small;
        PriorityQueue<Integer> large;

        public MedianFinder() {
            small = new PriorityQueue<>((a, b) -> (b - a));
            large = new PriorityQueue<>();
        }

        public void addNum(int num) {
            small.add(num);
            if (small.size() > large.size()) {
                large.add(small.poll());
            } else {
                large.add(small.poll());
                small.add(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() == large.size()) {
                return (small.peek() + large.peek()) / 2.0;
            } else {
                return large.peek();
            }
        }
    }

}
