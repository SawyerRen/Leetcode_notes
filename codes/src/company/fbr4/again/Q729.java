package company.fbr4.again;

import java.util.TreeMap;

public class Q729 {
    class MyCalendar {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer left = map.floorKey(start);
            if (left != null && map.get(left) > start) return false;
            Integer right = map.ceilingKey(start);
            if (right != null && right < end) return false;
            map.put(start, end);
            return true;
        }
    }
}
