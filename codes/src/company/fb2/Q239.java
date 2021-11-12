package company.fb2;

import java.util.LinkedList;

public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (list.size() > 0 && list.getFirst() < i - k + 1) {
                list.removeFirst();
            }
            while (list.size() > 0 && nums[i] > nums[list.getLast()]) {
                list.removeLast();
            }
            list.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[list.getFirst()];
            }
        }
        return res;
    }
}
