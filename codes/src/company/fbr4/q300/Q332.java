package company.fbr4.q300;

import java.util.*;

public class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        helper(res, map, "JFK");
        return res;
    }

    private void helper(LinkedList<String> res, Map<String, PriorityQueue<String>> map, String airport) {
        PriorityQueue<String> next = map.get(airport);
        while (next != null && !next.isEmpty()) {
            helper(res, map, next.poll());
        }
        res.addFirst(airport);
    }
}
