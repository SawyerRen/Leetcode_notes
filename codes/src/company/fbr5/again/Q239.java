package company.fbr5.again;

import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && i - k + 1 > list.peekFirst()) {
                list.pollFirst();
            }
            while (!list.isEmpty() && nums[i] > nums[list.peekLast()]) {
                list.pollLast();
            }
            list.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[list.peekFirst()];
            }
        }
        return res;
    }
}
