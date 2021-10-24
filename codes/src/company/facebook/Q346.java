package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
}

class MovingAverage {
    int size;
    Queue<Integer> queue;
    double sum;

    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (this.size == queue.size()) {
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }
}