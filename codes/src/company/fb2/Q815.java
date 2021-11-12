package company.fb2;

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
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        boolean[] routeVisited = new boolean[routes.length];
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer stop = queue.poll();
                if (stop == target) return level;
                for (Integer j : map.get(stop)) {
                    if (routeVisited[j]) continue;
                    for (int nextStop : routes[j]) {
                        if (visited.contains(nextStop)) continue;
                        queue.add(nextStop);
                        visited.add(nextStop);
                    }
                    routeVisited[j] = true;
                }
            }
            level++;
        }
        return -1;
    }
}
