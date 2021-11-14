package company.fbfinal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while (!list.isEmpty() && heights[i] >= heights[list.getLast()]) {
                list.removeLast();
            }
            list.addLast(i);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.removeFirst();
        }
        return res;
    }

    public int[] findBuildings1(int[] heights) {
        int n = heights.length;
        int maxHeight = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (maxHeight < heights[i]) {
                maxHeight = heights[i];
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
