package company.fbr5.q800;

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
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBus = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        queue.add(source);
        visitedStops.add(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer stop = queue.poll();
                if (stop == target) return res;
                for (Integer bus : map.get(stop)) {
                    if (visitedBus.contains(bus)) continue;
                    visitedBus.add(bus);
                    for (int nextStop : routes[bus]) {
                        if (visitedStops.contains(nextStop)) continue;
                        queue.add(nextStop);
                        visitedStops.add(nextStop);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
