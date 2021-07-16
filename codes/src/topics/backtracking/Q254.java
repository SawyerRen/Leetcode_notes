package topics.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Q254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (n <= 2) return res;
        helper(res, n, 2, new LinkedList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int n, int factor, LinkedList<Integer> list) {
        if (n == 1 && list.size() > 1) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = factor; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(res, n / i, i, list);
                list.removeLast();
            }
        }
    }
}
