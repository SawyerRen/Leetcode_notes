package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int k, int n, int start) {
        if (list.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
