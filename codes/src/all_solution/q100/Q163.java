package all_solution.q100;

import java.util.ArrayList;
import java.util.List;

public class Q163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            add2List(res, lower, upper);
            return res;
        }
        if (lower < nums[0]) add2List(res, lower, nums[0] - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                add2List(res, nums[i] + 1, nums[i + 1] - 1);
            }
        }
        if (nums[nums.length - 1] < upper) add2List(res, nums[nums.length - 1] + 1, upper);
        return res;
    }

    private void add2List(List<String> res, int lower, int upper) {
        if (lower == upper) res.add(String.valueOf(lower));
        else res.add(lower + "->" + upper);
    }
}
