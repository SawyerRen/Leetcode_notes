package company.fbr5.other;

import java.util.*;

public class ListIterator {
    List<List<Integer>> lists;
    PriorityQueue<int[]> pq;

    public ListIterator(List<List<Integer>> lists) {
        this.lists = lists;
        pq = new PriorityQueue<>((a, b) -> lists.get(a[0]).get(a[1]) - lists.get(b[0]).get(b[1]));
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > 0) {
                pq.add(new int[]{i, 0});
            }
        }
    }

    Integer next() {
        if (!hasNext()) return null;
        int[] index = pq.poll();
        int value = lists.get(index[0]).get(index[1]);
        if (index[1] < lists.get(index[0]).size() - 1) {
            pq.add(new int[]{index[0], index[1] + 1});
        }
        return value;
    }

    boolean hasNext() {
        return !pq.isEmpty();
    }
}
