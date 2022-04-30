package all_solution.q1400;

import java.util.*;

public class Q1429 {
    class FirstUnique {
        Queue<Integer> queue;
        Map<Integer, Integer> map;

        public FirstUnique(int[] nums) {
            queue = new LinkedList<>();
            map = new HashMap<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.poll();
            }
            return queue.isEmpty() ? -1 : queue.peek();
        }

        public void add(int value) {
            map.put(value, map.getOrDefault(value, 0) + 1);
            queue.add(value);
        }
    }
}
