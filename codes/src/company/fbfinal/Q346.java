package company.fbfinal;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
    class MovingAverage {
        Queue<Integer> queue = new LinkedList<>();
        double sum = 0;
        int capacity;

        public MovingAverage(int size) {
            this.capacity = size;
        }

        public double next(int val) {
            if (queue.size() == capacity) {
                sum -= queue.poll();
            }
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
