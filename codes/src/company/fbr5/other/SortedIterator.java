package company.fbr5.other;

import java.util.*;

public class SortedIterator {
    class Node {
        int val;
        Iterator<Integer> iterator;

        public Node(int val, Iterator<Integer> iterator) {
            this.val = val;
            this.iterator = iterator;
        }
    }

    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

    public SortedIterator(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            if (list.size() > 0) {
                Iterator<Integer> iterator = list.iterator();
                Node node = new Node(iterator.next(), iterator);
                pq.add(node);
            }
        }
    }

    boolean hasNext() {
        return !pq.isEmpty();
    }

    Integer next() {
        if (!hasNext()) return null;
        Node node = pq.poll();
        if (node.iterator.hasNext()) {
            pq.add(new Node(node.iterator.next(), node.iterator));
        }
        return node.val;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 4, 5, 8, 9));
        list.add(Arrays.asList(3, 4, 4, 6));
        list.add(Arrays.asList(0, 2, 8));
        SortedIterator iterator = new SortedIterator(list);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
