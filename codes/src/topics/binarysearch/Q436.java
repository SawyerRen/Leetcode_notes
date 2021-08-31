package topics.binarysearch;

import java.util.Map;
import java.util.TreeMap;

public class Q436 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        // 保存interval的start和index
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            // 寻找大于interval[1]的最小值key
            Integer key = map.ceilingKey(intervals[i][1]);
            if (key != null) {
                res[i] = map.get(key);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
