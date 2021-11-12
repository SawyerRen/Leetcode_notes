package company.fbr4.q1400;

import java.util.HashMap;
import java.util.Map;

public class Q1748 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : nums) {
            if (map.get(num) == 1) res += num;
        }
        return res;
    }
}
