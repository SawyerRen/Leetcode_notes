package company.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Q215 {
//    public int findKthLargest(int[] nums, int k) {
//        k = nums.length - k;
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            int pivotIndex = helper(nums, left, right);
//        }
//    }
//
//    private int helper(int[] nums, int left, int right) {
//        int randomIndex = new Random().nextInt(right - left + 1) + left;
//
//    }
//
//    void swap(int[] nums, int i, int j) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
