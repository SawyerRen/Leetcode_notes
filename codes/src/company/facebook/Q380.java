package company.facebook;

import java.util.*;

public class Q380 {
}

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
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
        if (index < list.size() - 1) {
            Integer last = list.remove(list.size() - 1);
            list.set(index, last);
            map.remove(val);
            map.put(last, index);
        } else {
            list.remove(list.size() - 1);
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}