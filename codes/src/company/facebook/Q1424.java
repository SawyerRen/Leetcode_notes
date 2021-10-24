package company.facebook;

import java.util.*;

public class Q1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int maxKey = 0;
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;
                maxKey = Math.max(maxKey, key);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(nums.get(i).get(j));
                count++;
            }
        }
        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i < maxKey + 1; i++) {
            List<Integer> list = map.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                res[index++] = list.get(j);
            }
        }
        return res;
    }
}
