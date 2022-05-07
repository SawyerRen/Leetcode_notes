package all_solution.q1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        int[] res = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            while (entry.getValue() > 0) {
                res[index++] = entry.getKey();
                entry.setValue(entry.getValue() - 1);
            }
        }
        return res;
    }
}
