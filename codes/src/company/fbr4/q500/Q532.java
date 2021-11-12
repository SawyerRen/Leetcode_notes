package company.fbr4.q500;

import java.util.HashMap;
import java.util.Map;

public class Q532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) > 1) res++;
            } else {
                if (map.containsKey(num + k)) res++;
            }
        }
        return res;
    }
}
