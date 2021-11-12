package company.fbr5.q300;

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
        List<Integer>[] lists = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            if (lists[count] == null) lists[count] = new ArrayList<>();
            lists[count].add(num);
        }
        int[] res = new int[k];
        int count = 0;
        for (int i = lists.length - 1; i > 0; i--) {
            if (lists[i] != null) {
                if (k == 0) break;
                for (Integer num : lists[i]) {
                    res[count++] = num;
                }
                k -= lists[i].size();
            }
        }
        return res;
    }
}
