package frequency.q300;

import java.util.*;

public class Q380 {
    class RandomizedSet {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int index = map.get(val);
            if (index != list.size() - 1) {
                int lastVal = list.get(list.size() - 1);
                list.set(index, lastVal);
                map.put(lastVal, index);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
