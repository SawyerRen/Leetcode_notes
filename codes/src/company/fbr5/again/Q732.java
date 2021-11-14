package company.fbr5.again;

import java.util.TreeMap;

public class Q732 {
    class MyCalendarThree {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendarThree() {

        }

        public int book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int res = 0, count = 0;
            for (Integer value : map.values()) {
                count += value;
                res = Math.max(res, count);
            }
            return res;
        }
    }
}
