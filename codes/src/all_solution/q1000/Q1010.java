package all_solution.q1000;

import java.util.HashMap;
import java.util.Map;

public class Q1010 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int t : time) {
            int need = (60 - t % 60) % 60;
            res += map.getOrDefault(need, 0);
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return res;
    }
}
