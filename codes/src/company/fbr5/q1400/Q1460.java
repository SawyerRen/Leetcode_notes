package company.fbr5.q1400;

import java.util.HashMap;
import java.util.Map;

public class Q1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : target) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : arr) {
            if (!map.containsKey(i)) return false;
            map.put(i, map.get(i) - 1);
            if (map.get(i) < 0) return false;
        }
        return true;
    }
}
