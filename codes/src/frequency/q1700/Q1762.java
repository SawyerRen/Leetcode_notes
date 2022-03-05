package frequency.q1700;

import java.util.LinkedList;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                list.addFirst(i);
                max = heights[i];
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.removeFirst();
        }
        return res;
    }
}
