package company.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
}

class MovingAverage {
    Queue<Integer> queue = new LinkedList<>();
    double sum = 0;
    int size = 0;

    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            Integer poll = queue.poll();
            sum -= poll;
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }
}