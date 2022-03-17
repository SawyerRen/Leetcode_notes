package all_solution.q700;

import javax.swing.*;
import java.util.TreeMap;

public class Q729 {
    class MyCalendar {
        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
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
