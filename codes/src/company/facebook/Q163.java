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
        int n = nums.length;
        if (lower < nums[0]) {
            res.add(helper(lower, nums[0] - 1));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 > nums[i - 1]) {
                res.add(helper(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (upper > nums[n - 1]) {
            res.add(helper(nums[n - 1] + 1, upper));
        }
        return res;
    }

    private String helper(int i, int j) {
        if (i == j) return String.valueOf(i);
        return i + "->" + j;
    }
}
