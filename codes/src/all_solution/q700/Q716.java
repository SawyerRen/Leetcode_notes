package all_solution.q700;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Q716 {
}

class MaxStack {
    TreeMap<Integer, List<Node>> map;
    DoubleLinkedList list;

    public MaxStack() {
        map = new TreeMap<>();
        list = new DoubleLinkedList();
    }

    public void push(int x) {
        Node node = new Node(x);
        list.addLast(node);
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(node);
    }

    public int pop() {
        Node node = list.removeLast();
        List<Node> nodes = map.get(node.val);
        nodes.remove(nodes.size() - 1);
        if (nodes.size() == 0) map.remove(node.val);
        return node.val;
    }

    public int top() {
        return list.getLast().val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = map.lastKey();
        List<Node> nodes = map.get(max);
        Node remove = nodes.remove(nodes.size() - 1);
        if (nodes.size() == 0) map.remove(max);
        list.remove(remove);
        return max;
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void addLast(Node node) {
            node.pre = tail.pre;
            node.pre.next = node;
            node.next = tail;
            tail.pre = node;
        }

        Node removeLast() {
            Node node = tail.pre;
            node.pre.next = tail;
            tail.pre = node.pre;
            return node;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        Node getLast() {
            return tail.pre;
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