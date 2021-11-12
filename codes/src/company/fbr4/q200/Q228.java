package company.fbr4.q200;

import java.util.ArrayList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i], end = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                end++;
                i++;
            }
            res.add(helper(start, end));
        }
        return res;
    }

    private String helper(int start, int end) {
        if (start == end) return String.valueOf(start);
        return start + "->" + end;
    }
}
