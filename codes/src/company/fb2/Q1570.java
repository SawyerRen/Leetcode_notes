package company.fb2;

import java.util.ArrayList;
import java.util.List;

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
        int i = 0, j = 0;
        int res = 0;
        while (i < list.size() && j < vec.list.size()) {
            if (list.get(i)[0] == vec.list.get(j)[0]) {
                res += list.get(i)[1] * vec.list.get(j)[1];
                i++;
                j++;
            } else if (list.get(i)[0] < vec.list.get(j)[0]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}