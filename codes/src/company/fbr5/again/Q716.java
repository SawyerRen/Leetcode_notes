package company.fbr5.again;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q716 {
    class MaxStack {
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        DList nodes = new DList();

        public MaxStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            nodes.addLast(node);
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int pop() {
            int lastVal = nodes.removeLast();
            List<Node> list = map.get(lastVal);
            list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(lastVal);
            return lastVal;
        }

        public int top() {
            return nodes.getLast();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            Integer max = map.lastKey();
            List<Node> list = map.get(max);
            Node node = list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(max);
            nodes.remove(node);
            return max;
        }
    }

    class DList {
        Node head;
        Node tail;

        public DList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.pre = head;
        }

        void addLast(Node node) {
            node.next = tail;
            node.pre = tail.pre;
            tail.pre.next = node;
            tail.pre = node;
        }

        int getLast() {
            return tail.pre.val;
        }

        int removeLast() {
            Node node = tail.pre;
            node.pre.next = tail;
            tail.pre = node.pre;
            return node.val;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
