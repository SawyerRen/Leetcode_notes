package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
}

class MovingAverage {
    Queue<Integer> queue;
    double sum;
    int size;

    public MovingAverage(int size) {
        this.size = size;
        sum = 0.0;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }
}