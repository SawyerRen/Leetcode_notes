package company.fbr4.again;

import java.util.*;

public class Q815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new HashSet<>());
                map.get(stop).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStop = new HashSet<>();
        Set<Integer> visitedBus = new HashSet<>();
        queue.add(source);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer stop = queue.poll();
                if (stop.equals(target)) return res;
                if (map.containsKey(stop)) {
                    for (Integer bus : map.get(stop)) {
                        if (visitedBus.contains(bus)) continue;
                        visitedBus.add(bus);
                        for (int nextStop : routes[bus]) {
                            if (visitedStop.contains(nextStop)) continue;
                            visitedStop.add(nextStop);
                            queue.add(nextStop);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
