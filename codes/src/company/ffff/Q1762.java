package company.ffff;

import java.util.ArrayList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }
}
