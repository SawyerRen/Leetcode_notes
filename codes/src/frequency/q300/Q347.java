package frequency.q300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List[] counts = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            if (counts[count] == null) counts[count] = new ArrayList<Integer>();
            counts[count].add(num);
        }
        int[] res = new int[k];
        for (int i = counts.length - 1; i >= 0; i--) {
            if (k == 0) break;
            if (counts[i] != null) {
                for (Object num : counts[i]) {
                    res[--k] = (int) num;
                }
            }
        }
        return res;
    }
}
