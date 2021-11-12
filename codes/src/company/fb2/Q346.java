package company.fb2;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
    class MovingAverage {
        Queue<Integer> queue;
        double sum = 0;
        int size;

        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            if (size == queue.size()) {
                sum -= queue.poll();
            }
            sum += val;
            queue.add(val);
            return sum / queue.size();
        }
    }
}
