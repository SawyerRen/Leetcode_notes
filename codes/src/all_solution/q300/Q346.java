package all_solution.q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
}

class MovingAverage {
    Queue<Integer> queue = new LinkedList<>();
    int size;
    double sum;

    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
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
