package all_solution.q200;

import java.util.PriorityQueue;

public class Q295 {

}

class MedianFinder {
    PriorityQueue<Integer> small = new PriorityQueue<>();
    PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> b - a);
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
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
}
