package topics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new LinkedList<>(), candidates, target, 0, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int[] candidates, int target, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target, sum + candidates[i], i);
            list.removeLast();
        }
    }
}
