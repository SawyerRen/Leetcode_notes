package all_solution.q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        while (!pq.isEmpty() && k-- > 0) {
            int[] poll = pq.poll();
            res.add(Arrays.asList(poll[0], poll[1]));
            int index = poll[2];
            if (index == nums2.length - 1) continue;
            pq.add(new int[]{poll[0], nums2[index + 1], index + 1});
        }
        return res;
    }
}
