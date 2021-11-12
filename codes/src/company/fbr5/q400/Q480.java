package company.fbr5.q400;

import java.util.PriorityQueue;

public class Q480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> {
            if (nums[a] == nums[b]) return a - b;
            return nums[a] - nums[b];
        });
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> {
            if (nums[b] == nums[a]) return b - a;
            return nums[b] - nums[a];
        });
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            large.add(i);
        }
        balance(small, large);
        res[0] = getMedian(small, large, nums, k);
        for (int i = k; i < nums.length; i++) {
            if (!large.remove(i - k)) small.remove(i - k);
            small.add(i);
            large.add(small.poll());
            balance(small, large);
            res[i - k + 1] = getMedian(small, large, nums, k);
        }
        return res;
    }

    private double getMedian(PriorityQueue<Integer> small, PriorityQueue<Integer> large, int[] nums, int k) {
        if (k % 2 == 0) {
            return (double) (nums[small.peek()] + nums[large.peek()]) / 2;
        } else {
            return (double) nums[small.peek()];
        }
    }


    private void balance(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        while (small.size() < large.size()) {
            small.add(large.poll());
        }
    }
}
