package frequency.q200;

import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!list.isEmpty() && list.peekFirst() < i - k + 1) {
                list.removeFirst();
            }
            while (!list.isEmpty() && nums[list.peekLast()] < nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}
