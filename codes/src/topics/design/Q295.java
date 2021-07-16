package topics.design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q295 {
}

class MedianFinder {
    PriorityQueue<Integer> large = new PriorityQueue<>();
    PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
    boolean even;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        even = true;
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
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}