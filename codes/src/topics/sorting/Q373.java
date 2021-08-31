package topics.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0 || k == 0) return res;
        for (int num : nums1) {
            pq.offer(new int[]{num, nums2[0], 0});
        }
        while (k > 0 && !pq.isEmpty()) {
            k--;
            int[] poll = pq.poll();
            int num1 = poll[0], num2 = poll[1], index = poll[2];
            List<Integer> list = new ArrayList<>();
            list.add(num1);
            list.add(num2);
            res.add(list);
            if (index < n - 1) pq.add(new int[]{num1, nums2[index + 1], index + 1});
        }
        return res;
    }

    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                pq.add(new int[]{n1, n2});
                while (pq.size() > k) pq.poll();
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(poll[0]);
            list.add(poll[1]);
            res.add(list);
        }
        return res;
    }
}
