package company.fbr3;

import java.util.*;

class SortedIterator implements Iterator<Integer> {
    class Node {
        int val;
        Iterator<Integer> iterator;

        public Node(int val, Iterator<Integer> iterator) {
            this.val = val;
            this.iterator = iterator;
        }
    }

    PriorityQueue<Node> pq;

    public SortedIterator(List<List<Integer>> lists) {
        pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (List<Integer> list : lists) {
            Iterator<Integer> iterator = list.iterator();
            if (iterator.hasNext()) {
                pq.add(new Node(iterator.next(), iterator));
            }
        }
    }

    public boolean hasNext() {
        return !pq.isEmpty();
    }

    public Integer next() {
        if (pq.isEmpty()) return null;
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
