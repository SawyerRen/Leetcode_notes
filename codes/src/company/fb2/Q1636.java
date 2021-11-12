package company.fb2;

import java.util.*;

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
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            for (int j = 0; j < count; j++) {
                nums[i++] = num;
            }
        }
        return nums;
    }
}
