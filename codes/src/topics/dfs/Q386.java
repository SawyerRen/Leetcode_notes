package topics.dfs;

import java.util.ArrayList;
import java.util.List;

public class Q386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            helper(res, i, n);
        }
        return res;
    }

    private void helper(List<Integer> res, int val, int n) {
        if (val > n) return;
        res.add(val);
        for (int i = 0; i < 10; i++) {
            helper(res, val * 10 + i, n);
        }
    }
}
