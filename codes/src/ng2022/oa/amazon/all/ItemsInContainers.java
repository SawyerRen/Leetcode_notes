package ng2022.oa.amazon.all;

import java.util.Map;
import java.util.TreeMap;

public class ItemsInContainers {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0, count = 0; i < s.length(); i++)
            if (s.charAt(i) == '|')
                m.put(i, count);
            else count++;
        int[] r = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Map.Entry<Integer, Integer> left = m.ceilingEntry(queries[i][0]), right = m.floorEntry(queries[i][1]);
            if (left != null && right != null)
                r[i] = Math.max(0, right.getValue() - left.getValue());
        }
        return r;
    }
}
