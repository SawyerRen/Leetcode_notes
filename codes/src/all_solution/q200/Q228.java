package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i], end = nums[i];
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                end = nums[i + 1];
                i++;
            }
            res.add(n2s(start, end));
        }
        return res;
    }

    private String n2s(int start, int end) {
        if (start == end) return String.valueOf(start);
        return start + "->" + end;
    }
}
