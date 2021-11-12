package company.fbr5.q200;

import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.size() > 0 && list.peekFirst() < i - k + 1) {
                list.removeFirst();
            }
            while (list.size() > 0 && nums[i] > nums[list.peekLast()]) {
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
