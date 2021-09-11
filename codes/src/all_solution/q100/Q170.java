package all_solution.q100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q170 {
}

class TwoSum {
    List<Integer> list;
    Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            list.add(number);
            map.put(number, 1);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer num : list) {
            int target = value - num;
            if (target == num && map.get(num) >= 2 || target != num && map.containsKey(target)) return true;
        }
        return false;
    }
}