package company.fbr5.q1400;

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
        list.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) return b.getKey() - a.getKey();
            return a.getValue() - b.getValue();
        });
        int[] res = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            for (int i = 0; i < count; i++) {
                res[index++] = num;
            }
        }
        return res;
    }
}
