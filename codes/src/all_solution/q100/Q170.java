package all_solution.q100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q170 {
}

class TwoSum {
    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Integer val : map.keySet()) {
            if (val + val == value) {
                if (map.get(val) >= 2) return true;
            } else if (map.containsKey(value - val)) return true;
        }
        return false;
    }
}