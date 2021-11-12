package company.fb2;

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
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            Integer index = map.get(val);
            if (index != list.size() - 1) {
                Integer lastVal = list.get(list.size() - 1);
                map.put(lastVal, index);
                list.set(index, lastVal);
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
