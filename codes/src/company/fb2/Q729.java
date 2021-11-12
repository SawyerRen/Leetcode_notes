package company.fb2;

import java.util.TreeMap;

public class Q729 {
    class MyCalendar {
        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer left = map.floorKey(start);
            Integer right = map.ceilingKey(start);
            if (left != null && map.get(left) > start) return false;
            if (right != null && right < end) return false;
            map.put(start, end);
            return true;
        }
    }
}
