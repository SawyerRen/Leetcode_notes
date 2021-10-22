package company.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1570 {
}

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
        int res = 0;
        int i = 0, j = 0;
        while (i < list.size() && j < vec.list.size()) {
            int[] pair1 = list.get(i);
            int[] pair2 = vec.list.get(j);
            if (pair1[0] == pair2[0]) {
                res += pair1[1] * pair2[1];
                i++;
                j++;
            } else if (pair1[0] > pair2[0]) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}