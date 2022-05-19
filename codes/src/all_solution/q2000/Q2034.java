package all_solution.q2000;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Q2034 {
    class StockPrice {
        TreeMap<Integer, Integer> recordMap = new TreeMap<>();
        TreeMap<Integer, Set<Integer>> valsMap = new TreeMap<>();

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if (recordMap.containsKey(timestamp)) {
                Integer val = recordMap.get(timestamp);
                valsMap.get(val).remove(timestamp);
                if (valsMap.get(val).size() == 0) valsMap.remove(val);
            }
            recordMap.put(timestamp, price);
            valsMap.putIfAbsent(price, new HashSet<>());
            valsMap.get(price).add(timestamp);
        }

        public int current() {
            return recordMap.lastEntry().getValue();
        }

        public int maximum() {
            return valsMap.lastKey();
        }

        public int minimum() {
            return valsMap.firstKey();
        }
    }
}
