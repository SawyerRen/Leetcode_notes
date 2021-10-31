package company.fbr3;

import java.util.ArrayList;
import java.util.List;

public class Q163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(helper(lower, upper));
            return res;
        }
        if (lower < nums[0]) res.add(helper(lower, nums[0] - 1));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) res.add(helper(nums[i - 1] + 1, nums[i] - 1));
        }
        if (nums[nums.length - 1] < upper) res.add(helper(nums[nums.length - 1] + 1, upper));
        return res;
    }

    String helper(int low, int high) {
        if (low == high) return String.valueOf(low);
        return low + "->" + high;
    }
}
