package company.fbr5.q700;

import java.util.TreeMap;

public class Q715 {
    class RangeModule {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public RangeModule() {

        }

        public void addRange(int left, int right) {
            Integer start = map.floorKey(left);
            Integer end = map.floorKey(right);
            if (start != null && map.get(start) >= left) {
                left = start;
            }
            if (end != null && map.get(end) > right) {
                right = map.get(end);
            }
            map.put(left, right);
            map.subMap(left, false, right, true).clear();
        }

        public boolean queryRange(int left, int right) {
            Integer start = map.floorKey(left);
            if (start != null && map.get(start) >= right) return true;
            return false;
        }

        public void removeRange(int left, int right) {
            Integer end = map.floorKey(right);
            if (end != null && map.get(end) > right) {
                map.put(right, map.get(end));
            }
            Integer start = map.floorKey(left);
            if (start != null && map.get(start) > left) {
                map.put(start, left);
            }
            map.subMap(left, true, right, false).clear();
        }
    }
}
