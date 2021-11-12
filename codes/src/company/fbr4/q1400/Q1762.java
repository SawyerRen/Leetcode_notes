package company.fbr4.q1400;

import java.util.ArrayList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int maxH = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxH) {
                maxH = heights[i];
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
