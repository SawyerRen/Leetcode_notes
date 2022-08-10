package ng2022.oa.amazon.high;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinKeypadClickCount {
    static int minKeyPress(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
        pq.addAll(freq.keySet());
        int count = 0;
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            res += (count / 9 + 1) * freq.get(c);
            count++;
        }
        return res;
    }
}
