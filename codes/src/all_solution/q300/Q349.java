package all_solution.q300;

import java.util.*;

public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> res = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) res.add(i);
        }
        int[] out = new int[res.size()];
        int i = 0;
        for (Integer v : res) {
            out[i++] = v;
        }
        return out;
    }
}
