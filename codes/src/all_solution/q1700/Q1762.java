package all_solution.q1700;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        int max = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                list.addFirst(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.removeFirst();
        }
        return res;
    }
}
