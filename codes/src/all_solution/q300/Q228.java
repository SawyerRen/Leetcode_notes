package all_solution.q300;

import java.util.ArrayList;
import java.util.List;

public class Q228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right + 1 < nums.length && nums[right + 1] - nums[right] == 1) {
                right++;
            }
            add2List(res, nums[left], nums[right]);
            right++;
            left = right;
        }
        return res;
    }

    private void add2List(List<String> res, int n1, int n2) {
        if (n1 == n2) {
            res.add(String.valueOf(n1));
        } else {
            res.add(n1 + "->" + n2);
        }
    }
}
