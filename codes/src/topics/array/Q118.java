package topics.array;

import java.util.ArrayList;
import java.util.List;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        for (int size = 1; size <= numRows; size++) {
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                if (i == 0 || i == size - 1) list.add(1);
                else {
                    list.add(res.get(size - 2).get(i - 1) + res.get(size - 2).get(i));
                }
            }
            res.add(list);
        }
        return res;
    }
}
