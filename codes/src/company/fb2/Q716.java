package company.fb2;

import java.util.*;

public class Q716 {
    class MaxStack {
        TreeMap<Integer, List<Node>> map;
        DoubleList list;

        public MaxStack() {
            map = new TreeMap<>();
            list = new DoubleList();
        }

        public void push(int x) {
            Node node = new Node(x);
            list.addLast(node);
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int pop() {
            int val = list.removeLast();
            List<Node> list = map.get(val);
            list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(val);
            return val;
        }

        public int top() {
            return list.getLast();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = map.lastKey();
            List<Node> nodes = map.get(max);
            Node node = nodes.remove(nodes.size() - 1);
            list.remove(node);
            if (nodes.size() == 0) map.remove(max);
            return max;
        }
    }

    class DoubleList {
        Node head;
        Node tail;

        public DoubleList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.pre = head;
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

        void addLast(Node node) {
            node.next = tail;
            node.pre = tail.pre;
            node.pre.next = node;
            tail.pre = node;
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
