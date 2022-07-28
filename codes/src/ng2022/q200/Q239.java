package ng2022.q200;

import java.util.LinkedList;
import java.util.Queue;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
