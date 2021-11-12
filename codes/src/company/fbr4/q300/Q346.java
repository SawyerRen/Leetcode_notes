package company.fbr4.q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
    class MovingAverage {
        Queue<Integer> queue = new LinkedList<>();
        double sum = 0;
        int size;

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            sum += val;
            queue.add(val);
            return sum / queue.size();
        }
    }
}
