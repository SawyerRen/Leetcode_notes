package company.fbr5.other;

import java.util.*;

public class ListIterator {
    PriorityQueue<int[]> pq;
    List<List<Integer>> lists;

    public ListIterator(List<List<Integer>> lists) {
        this.lists = lists;
        pq = new PriorityQueue<>((a, b) -> lists.get(a[0]).get(a[1]) - lists.get(b[0]).get(b[1]));
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() > 0) pq.add(new int[]{i, 0});
        }
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public int next() {
        int[] index = pq.poll();
        if (index[1] < lists.get(index[0]).size() - 1) {
            pq.add(new int[]{index[0], index[1] + 1});
        }
        return lists.get(index[0]).get(index[1]);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 4, 5, 8, 9));
        list.add(Arrays.asList(3, 4, 4, 6));
        list.add(Arrays.asList(0, 2, 8));
        ListIterator iterator = new ListIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
