package all_solution.q0;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new LinkedList<Integer>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int[] nums, int start) {
        res.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.removeLast();
        }
    }
}
