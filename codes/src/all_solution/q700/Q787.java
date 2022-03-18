package all_solution.q700;

import java.util.*;

public class Q787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] flight : flights) {
                int start = flight[0], next = flight[1], price = flight[2];
                if (cost[start] != Integer.MAX_VALUE) {
                    temp[next] = Math.min(temp[next], cost[start] + price);
                }
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0, k + 1});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int start = poll[0], price = poll[1], remainK = poll[2];
            if (start == dst) return price;
            if (remainK > 0) {
                if (map.containsKey(start)) {
                    for (Integer nextCity : map.get(start).keySet()) {
                        pq.add(new int[]{nextCity, price + map.get(start).get(nextCity), remainK - 1});
                    }
                }
            }
        }
        return -1;
    }
}
