package company.facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (nums[o1] == nums[o2]) return Integer.compare(o1, o2);
                return Integer.compare(nums[o1], nums[o2]);
            }
        };
        PriorityQueue<Integer> left = new PriorityQueue<>(comparator.reversed());
        PriorityQueue<Integer> right = new PriorityQueue<>(comparator);
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            left.add(i);
        }
        balance(left, right);
        res[0] = getMedian(nums, k, left, right);
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            if (!left.remove(i - k)) {
                right.remove(i - k);
            }
            right.add(i);
            left.add(right.poll());
            balance(left, right);
            res[index++] = getMedian(nums, k, left, right);
        }
        return res;
    }

    private double getMedian(int[] nums, int k, PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (k % 2 == 0) {
            return nums[right.peek()];
        } else {
            return (double) (nums[left.peek()] + nums[right.peek()]) / 2;
        }
    }

    private void balance(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (left.size() > right.size()) {
            right.add(left.poll());
        }
    }
}
