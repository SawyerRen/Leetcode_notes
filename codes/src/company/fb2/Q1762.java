package company.fb2;

import java.util.ArrayList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        int maxHeight = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                list.add(i);
                maxHeight = heights[i];
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }
}
