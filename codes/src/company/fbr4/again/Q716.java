package company.fbr4.again;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q716 {
    class MaxStack {
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        DoubleList nodes = new DoubleList();

        public MaxStack() {

        }

        public void push(int x) {
            Node node = new Node(x);
            nodes.addLast(node);
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(node);
        }

        public int pop() {
            Node node = nodes.removeLast();
            List<Node> list = map.get(node.val);
            list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(node.val);
            return node.val;
        }

        public int top() {
            return nodes.getLast().val;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max = map.lastKey();
            List<Node> list = map.get(max);
            Node node = list.remove(list.size() - 1);
            nodes.remove(node);
            if (list.size() == 0) map.remove(max);
            return max;
        }
    }

    class DoubleList {
        Node head = new Node(0);
        Node tail = new Node(0);

        void addLast(Node node) {
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        Node getLast() {
            return tail.pre;
        }

        Node removeLast() {
            Node node = tail.pre;
            node.pre.next = tail;
            tail.pre = node.pre;
            return node;
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
