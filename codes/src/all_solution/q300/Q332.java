package all_solution.q300;

import java.util.*;

public class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> list = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        helper(list, map, "JFK");
        return list;
    }

    private void helper(LinkedList<String> list, Map<String, PriorityQueue<String>> map, String airport) {
        PriorityQueue<String> pq = map.get(airport);
        while (pq != null && !pq.isEmpty()) {
            helper(list, map, pq.poll());
        }
        list.addFirst(airport);
    }
}
