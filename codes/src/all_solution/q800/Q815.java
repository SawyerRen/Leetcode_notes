package all_solution.q800;

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
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        queue.add(source);
        visitedStops.add(source);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == target) return res;
                if (map.containsKey(poll)) {
                    for (Integer route : map.get(poll)) {
                        if (visitedRoutes.contains(route)) continue;
                        visitedRoutes.add(route);
                        for (int nextStop : routes[route]) {
                            if (visitedStops.contains(nextStop)) continue;
                            queue.add(nextStop);
                            visitedStops.add(nextStop);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
