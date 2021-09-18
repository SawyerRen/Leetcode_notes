package all_solution.q300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                for (int i = 0; i < Math.min(map1.get(key), map2.get(key)); i++) {
                    list.add(key);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
