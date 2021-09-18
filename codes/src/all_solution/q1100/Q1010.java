package all_solution.q1100;

import java.util.HashMap;
import java.util.Map;

public class Q1010 {
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : time) {
            int another = (60 - i % 60) % 60;
            if (map.containsKey(another)) {
                res += map.get(another);
            }
            map.put(i % 60, map.getOrDefault(i % 60, 0) + 1);
        }
        return res;
    }
}
