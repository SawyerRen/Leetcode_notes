package company.facebook;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Q460 {
}

class LFUCache {
    Map<Integer, Integer> valMap;
    Map<Integer, Integer> countMap;
    Map<Integer, LinkedHashSet<Integer>> lists;
    int capacity;
    int minCount = -1;

    public LFUCache(int capacity) {
        valMap = new HashMap<>();
        countMap = new HashMap<>();
        lists = new HashMap<>();
        this.capacity = capacity;
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!valMap.containsKey(key)) return -1;
        int count = countMap.get(key);
        countMap.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == minCount && lists.get(count).size() == 0) {
            minCount++;
        }
        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);
        return valMap.get(key);
    }

    public void put(int key, int value) {
        if (valMap.containsKey(key)) {
            valMap.put(key, value);
            get(key);
            return;
        }
        if (valMap.size() > capacity) {
            int exit = lists.get(minCount).iterator().next();
            lists.get(minCount).remove(exit);
            valMap.remove(exit);
        }
        valMap.put(key, value);
        countMap.put(key, 1);
        minCount = 1;
        lists.get(1).add(key);
    }
}
