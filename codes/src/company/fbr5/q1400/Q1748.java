package company.fbr5.q1400;

import java.util.HashMap;
import java.util.Map;

public class Q1748 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer num : map.keySet()) {
            if (map.get(num) == 1) res += num;
        }
        return res;
    }
}
