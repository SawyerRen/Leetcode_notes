package company.fbr4.again;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, src, k + 1});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int price = poll[0];
            int stop = poll[1];
            int remainK = poll[2];
            if (stop == dst) return price;
            if (remainK > 0) {
                if (map.containsKey(stop)) {
                    for (Integer nextStop : map.get(stop).keySet()) {
                        pq.add(new int[]{price + map.get(stop).get(nextStop), nextStop, remainK - 1});
                    }
                }
            }
        }
        return -1;
    }
}
