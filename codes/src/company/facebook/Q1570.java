package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q1570 {
}

class SparseVector {
    Map<Integer, Integer> nonZeroIndexMap;
    int len = 0;

    SparseVector(int[] nums) {
        nonZeroIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZeroIndexMap.put(i, nums[i]);
            }
        }
        len = nums.length;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        if (this.len == 0 || vec.len == 0) return 0;
        if (this.len > vec.len) return vec.dotProduct(this);
        int res = 0;
        for (Integer index : nonZeroIndexMap.keySet()) {
            if (vec.nonZeroIndexMap.containsKey(index)) {
                res += nonZeroIndexMap.get(index) * vec.nonZeroIndexMap.get(index);
            }
        }
        return res;
    }
}