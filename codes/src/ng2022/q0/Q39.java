package ng2022.q0;

import java.util.ArrayList;
import java.util.List;

public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, candidates, new ArrayList<Integer>(), target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, ArrayList<Integer> list, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, candidates, list, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
