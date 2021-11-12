package company.fb2;

import java.util.*;

public class Q332 {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String airport) {
        PriorityQueue<String> next = map.get(airport);
        while (next != null && !next.isEmpty()) {
            dfs(next.poll());
        }
        res.addFirst(airport);
    }
}
