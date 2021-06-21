package topics.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<Integer>(), 0, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int start, int[] nums) {
        res.add(new LinkedList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res,list,i+1,nums);
            list.removeLast();
        }
    }
}
