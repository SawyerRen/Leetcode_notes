package company.facebook;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 变成最小值， 同时窗口长度 可以小于给定的k， 最后输出长度与给定原数组一致
public class Q239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (list.size() > 0 && list.getFirst() < i - k + 1) {
                list.pollFirst();
            }
            while (list.size() > 0 && nums[i] > nums[list.getLast()]) {
                list.pollLast();
            }
            list.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[list.peekFirst()];
            }
        }
        return res;
    }

    static public int[] minSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, nums[i]);
            res[i] = min;
        }
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && i - k + 1 > queue.peekFirst()) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[i] < nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i - k + 1 >= 0) {
                res[i] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(minSlidingWindow(nums, k)));
    }
}
