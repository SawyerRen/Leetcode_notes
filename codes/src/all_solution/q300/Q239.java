package all_solution.q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.add(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
