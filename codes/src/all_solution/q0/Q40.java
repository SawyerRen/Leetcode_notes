package all_solution.q0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, int target, int start, ArrayList<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            helper(res, candidates, target - candidates[i], i + 1, list);
            list.remove(list.get(list.size() - 1));
        }
    }
}
