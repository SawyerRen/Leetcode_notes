package topics.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q451 {
    public String frequencySort(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(hash.entrySet());
        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> poll = pq.poll();
            int count = poll.getValue();
            char c = poll.getKey();
            while (count-- > 0) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
