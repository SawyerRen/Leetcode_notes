package topics.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<>(), n, k, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k, i + 1);
            list.removeLast();
        }
    }
}
