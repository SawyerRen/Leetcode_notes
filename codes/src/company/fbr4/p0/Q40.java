package company.fbr4.p0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(res, list, nums, target - nums[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
