package company.fbr5.q1400;

import java.util.ArrayList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int maxHeight = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
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
