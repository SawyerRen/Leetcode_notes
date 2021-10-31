package company.fbr3;

import java.util.PriorityQueue;

public class Q480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> {
            if (nums[a] == nums[b]) return a - b;
            else return Integer.compare(nums[a], nums[b]);
        });
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> {
            if (nums[a] == nums[b]) return b - a;
            else return Integer.compare(nums[b], nums[a]);
        });
        int n = nums.length;
        double[] res = new double[n - k + 1];
        for (int i = 0; i < k; i++) {
            small.add(i);
        }
        balance(large, small);
        res[0] = getMedian(nums, k, small, large);
        int index = 1;
        for (int i = k; i < n; i++) {
            if (!small.remove(i - k)) {
                large.remove(i - k);
            }
            large.add(i);
            small.add(large.poll());
            balance(large, small);
            res[index++] = getMedian(nums, k, small, large);
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

    private void balance(PriorityQueue<Integer> large, PriorityQueue<Integer> small) {
        while (small.size() > large.size()) {
            large.add(small.poll());
        }
    }
}
