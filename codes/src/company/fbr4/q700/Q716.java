package company.fbr4.q700;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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
            map.putIfAbsent(node.val, new ArrayList<>());
            map.get(x).add(node);
            list.addLast(node);
        }

        public int pop() {
            Node node = list.removeLast();
            List<Node> list = map.get(node.val);
            list.remove(list.size() - 1);
            if (list.size() == 0) map.remove(node.val);
            return node.val;
        }

        public int top() {
            return list.getLast().val;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int maxKey = map.lastKey();
            List<Node> nodes = map.get(maxKey);
            Node node = nodes.remove(nodes.size() - 1);
            if (nodes.size() == 0) map.remove(maxKey);
            list.remove(node);
            return maxKey;
        }
    }

    class DoubleList {
        Node head;
        Node tail;

        public DoubleList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

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

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
