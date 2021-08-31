package topics.sliding_window;

import java.util.Comparator;
import java.util.TreeSet;

public class Q480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
            else return a - b;
        };
        TreeSet<Integer> small = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> large = new TreeSet<>(comparator);
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            small.add(i);
        }
        balance(small, large);
        res[0] = getMid(small, large, k, nums);
        for (int i = k; i < nums.length; i++) {
            if (small.contains(i - k)) small.remove(i - k);
            else large.remove(i - k);
            large.add(i);
            small.add(large.pollFirst());
            balance(small, large);
            res[i - k + 1] = getMid(small, large, k, nums);
        }
        return res;
    }

    private double getMid(TreeSet<Integer> small, TreeSet<Integer> large, int k, int[] nums) {
        if (k % 2 == 0) {
            return ((double) nums[small.first()] + nums[large.first()]) / 2;
        } else {
            return nums[large.first()];
        }
    }

    private void balance(TreeSet<Integer> small, TreeSet<Integer> large) {
        while (large.size() < small.size()) {
            large.add(small.pollFirst());
        }
    }
}
