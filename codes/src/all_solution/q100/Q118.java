package all_solution.q100;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int n = 1; n < numRows + 1; n++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i == 0 || i == n - 1) list.add(1);
                else {
                    list.add(res.get(n - 2).get(i - 1) + res.get(n - 2).get(i));
                }
            }
            res.add(list);
        }
        return res;
    }
}
