package company.fbr4.q400;

import java.util.PriorityQueue;

public class Q480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> {
            if (nums[a] == nums[b]) return a - b;
            else return nums[a] - nums[b];
        });
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> {
            if (nums[a] == nums[b]) return b - a;
            else return nums[b] - nums[a];
        });
        for (int i = 0; i < k; i++) {
            small.add(i);
        }
        balance(small, large);
        double[] res = new double[nums.length - k + 1];
        res[0] = getMedian(nums, k, small, large);
        for (int i = k; i < nums.length; i++) {
            if (!large.remove(i - k)) {
                small.remove(i - k);
            }
            large.add(i);
            small.add(large.poll());
            balance(small, large);
            res[i - k + 1] = getMedian(nums, k, small, large);
        }
        return res;
    }

    private double getMedian(int[] nums, int k, PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        if (k % 2 == 0) {
            return (double) (nums[small.peek()] + nums[large.peek()]) / 2;
        } else {
            return (double) nums[large.peek()];
        }
    }

    private void balance(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        while (small.size() > large.size()) {
            large.add(small.poll());
        }
    }
}
