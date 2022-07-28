package ng2022.q300;

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
        List[] lists = new List[nums.length + 1];
        for (Integer val : map.keySet()) {
            int count = map.get(val);
            if (lists[count] == null) lists[count] = new ArrayList<Integer>();
            lists[count].add(val);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = lists.length - 1; i > 0; i--) {
            if (index >= k) break;
            if (lists[i] != null) {
                for (Object o : lists[i]) {
                    res[index++] = (int) o;
                }
            }
        }
        return res;
    }
}
