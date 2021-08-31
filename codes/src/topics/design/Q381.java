package topics.design;

import java.util.*;

public class Q381 {
}

class RandomizedCollection {
    List<Integer> list;
    Map<Integer, LinkedHashSet<Integer>> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if (!contain) map.put(val, new LinkedHashSet<>());
        list.add(val);
        map.get(val).add(list.size() - 1);
        return !contain;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index < list.size() - 1) {
            Integer last = list.get(list.size() - 1);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(index);
            list.set(index, last);
        }
        list.remove(list.size() - 1);
        if (map.get(val).size() == 0) map.remove(val);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
