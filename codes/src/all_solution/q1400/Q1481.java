package all_solution.q1400;

import java.util.*;

public class Q1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        while (k-- > 0) {
            Map.Entry<Integer, Integer> entry = list.get(list.size() - 1);
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() == 0) list.remove(list.size() - 1);
        }
        return list.size();
    }
}
