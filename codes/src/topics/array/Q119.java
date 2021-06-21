package topics.array;

import java.util.ArrayList;
import java.util.List;

public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(0, 1);
            for (int j = 1; j < i; j++) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }
}
