package topics.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new LinkedList<>(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, LinkedList<Integer> list, int k, int n, int start) {
        if (k == 0) {
            if (n == 0) res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < 10; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.removeLast();
        }
    }
}
