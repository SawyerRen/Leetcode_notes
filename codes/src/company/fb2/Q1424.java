package company.fb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxKey = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                count++;
                maxKey = Math.max(maxKey, key);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(nums.get(i).get(j));
            }
        }
        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i <= maxKey; i++) {
            List<Integer> list = map.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                res[index++] = list.get(j);
            }
        }
        return res;
    }
}
