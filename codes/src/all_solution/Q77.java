package all_solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new LinkedList<Integer>(), n, k, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int n, int k, int start) {
        if (list.size() == 2) {
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
