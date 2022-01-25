package all_solution.q100;

import java.util.ArrayList;
import java.util.List;

public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) res.add(1);
                else if (j == 0) continue;
                else {
                    res.set(j, res.get(j) + res.get(j - 1));
                }
            }
        }
        return res;
    }
}
