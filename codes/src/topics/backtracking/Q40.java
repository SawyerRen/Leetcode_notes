package topics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        helper(res, new ArrayList<>(), candidates, target, visited, 0, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, boolean[] visited, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1] && !visited[i - 1]) continue;
            list.add(candidates[i]);
            visited[i] = true;
            helper(res, list, candidates, target, visited, sum + candidates[i], i + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
