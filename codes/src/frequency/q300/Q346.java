package frequency.q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
    class MovingAverage {
        Queue<Integer> queue;
        int size;
        int sum = 0;

        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            queue.add(val);
            sum += val;
            if (queue.size() > size) sum -= queue.poll();
            return (double) sum / queue.size();
        }
    }
}
