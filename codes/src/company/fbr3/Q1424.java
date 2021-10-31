package company.fbr3;

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
                maxKey = Math.max(key, maxKey);
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(nums.get(i).get(j));
                count++;
            }
        }
        int[] res = new int[count];
        int index = 0;
        for (int i = 0; i < maxKey + 1; i++) {
            List<Integer> list = map.get(i);
            for (int k = list.size() - 1; k >= 0; k--) {
                res[index++] = list.get(k);
            }
        }
        return res;
    }
}
