package all_solution.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
