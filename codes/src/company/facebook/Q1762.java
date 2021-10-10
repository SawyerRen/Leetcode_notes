package company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        if (heights.length == 0) return new int[0];
        List<Integer> list = new ArrayList<>();
        int rightMax = heights[heights.length - 1];
        list.add(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > rightMax) {
                list.add(i);
                rightMax = heights[i];
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(list.size() - i - 1);
        }
        return res;
    }
}
