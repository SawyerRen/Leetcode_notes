package topics.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Q454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int target = -(i + j);
                if (map.containsKey(target)) res += map.get(target);
            }
        }
        return res;
    }
}
