package company.facebook.freq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1570 {
    class SparseVector {
        List<int[]> list = new ArrayList<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    list.add(new int[]{i, nums[i]});
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int i = 0, j = 0;
            int res = 0;
            while (i < list.size() && j < vec.list.size()) {
                int[] n1 = list.get(i);
                int[] n2 = vec.list.get(j);
                if (n1[0] == n2[0]) {
                    res += n1[1] * n2[1];
                    i++;
                    j++;
                } else if (n1[0] < n2[0]) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }

    class SparseVector1 {
        Map<Integer, Integer> map = new HashMap<>();

        SparseVector1(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    map.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector1 vec) {
            int res = 0;
            for (Integer index : map.keySet()) {
                if (vec.map.containsKey(index)) {
                    res += map.get(index) * vec.map.get(index);
                }
            }
            return res;
        }
    }
}
