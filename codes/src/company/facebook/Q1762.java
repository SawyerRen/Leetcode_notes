package company.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int n = heights.length;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > max) list.add(i);
            max = Math.max(max, heights[i]);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(list.size() - i - 1);
        }
        return res;
    }
}
