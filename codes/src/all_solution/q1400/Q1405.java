package all_solution.q1400;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1405 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        if (a > 0) pq.add(new Pair(a, 'a'));
        if (b > 0) pq.add(new Pair(b, 'b'));
        if (c > 0) pq.add(new Pair(c, 'c'));
        StringBuilder builder = new StringBuilder();
        while (pq.size() > 1) {
            Pair poll1 = pq.poll();
            if (poll1.count >= 2) {
                builder.append(poll1.c).append(poll1.c);
                poll1.count -= 2;
            } else {
                builder.append(poll1.c);
                poll1.count -= 1;
            }
            Pair poll2 = pq.poll();
            if (poll2.count >= 2 && poll2.count > poll1.count) {
                builder.append(poll2.c).append(poll2.c);
                poll2.count -= 2;
            } else {
                builder.append(poll2.c);
                poll2.count -= 1;
            }
            if (poll1.count > 0) pq.add(poll1);
            if (poll2.count > 0) pq.add(poll2);
        }
        if (!pq.isEmpty()) {
            if (pq.peek().count >= 2) {
                builder.append(pq.peek().c).append(pq.peek().c);
            } else {
                builder.append(pq.peek().c);
            }
        }
        return builder.toString();
    }

    class Pair {
        int count;
        char c;

        public Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
}
