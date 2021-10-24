package company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(helper(lower, upper));
            return res;
        }
        if (lower < nums[0]) {
            res.add(helper(lower, nums[0] - 1));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - 1 > nums[i]) {
                res.add(helper(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            res.add(helper(nums[nums.length - 1] + 1, upper));
        }
        return res;
    }

    private String helper(int i, int j) {
        if (i == j) return String.valueOf(i);
        return i + "->" + j;
    }
}
