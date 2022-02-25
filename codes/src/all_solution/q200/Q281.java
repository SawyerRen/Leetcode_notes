package all_solution.q200;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q281 {
}

public class ZigzagIterator {
    Queue<Integer> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int i = 0;
        while (i < v1.size() || i < v2.size()) {
            Integer n1 = i < v1.size() ? v1.get(i) : null;
            Integer n2 = i < v2.size() ? v2.get(i) : null;
            if (n1 != null) queue.add(n1);
            if (n2 != null) queue.add(n2);
            i++;
        }
    }

    public int next() {
        if (!hasNext()) return -1;
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.size() > 0;
    }
}