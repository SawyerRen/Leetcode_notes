package all_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, int target, int start, List<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
