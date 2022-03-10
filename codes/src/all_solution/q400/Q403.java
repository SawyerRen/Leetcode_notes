package all_solution.q400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q403 {
    public boolean canCross(int[] stones) {
        if (stones.length == 0) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.put(0, new HashSet<>());
        map.get(0).add(1);
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (Integer step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) return true;
                Set<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step > 1) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }
        return false;
    }
}
