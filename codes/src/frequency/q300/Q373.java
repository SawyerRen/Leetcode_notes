package frequency.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        for (int i : nums1) {
            pq.add(new int[]{i, nums2[0], 0});
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] poll = pq.poll();
            int n1 = poll[0], n2 = poll[1], index = poll[2];
            res.add(Arrays.asList(n1, n2));
            if (index + 1 < nums2.length) pq.add(new int[]{n1, nums2[index + 1], index + 1});
        }
        return res;
    }
}
