package company.fbr5.q700;

import java.util.*;

public class Q716 {
    class MaxStack {
        DoubleList nodes = new DoubleList();
        TreeMap<Integer, List<Node>> map = new TreeMap<>();

        public MaxStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            nodes.addLast(node);
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int pop() {
            int val = nodes.removeLast();
            List<Node> list = map.get(val);
            list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(val);
            return val;
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
            Node remove = list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(max);
            nodes.remove(remove);
            return max;
        }
    }

    class DoubleList {
        Node head;
        Node tail;
        int size;

        public DoubleList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.pre = head;
        }

        void addLast(Node node) {
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
            size++;
        }

        int removeLast() {
            Node node = tail.pre;
            tail.pre = node.pre;
            node.pre.next = tail;
            size--;
            return node.val;
        }

        int getLast() {
            return tail.pre.val;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
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
