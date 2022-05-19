package all_solution.q2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0, less = 0;
        for (int num : nums) {
            if (num == target) count++;
            if (num < target) less++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(less + i);
        }
        return res;
    }
}
