package company.facebook;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Q460 {
}

class LFUCache {
    Map<Integer, Node> nodeMap;
    Map<Integer, DoubleList> countMap;
    int size, capacity, min;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        min = 0;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.val;
    }

    private void update(Node node) {
        int count = node.count;
        DoubleList list = countMap.get(count);
        list.remove(node);
        if (list.size == 0 && node.count == min) min++;
        node.count++;
        countMap.putIfAbsent(node.count, new DoubleList());
        countMap.get(node.count).addFirst(node);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            if (size == capacity) {
                DoubleList doubleList = countMap.get(min);
                int lastKey = doubleList.removeLast();
                nodeMap.remove(lastKey);
                size--;
            }
            Node node = new Node(key, value, 1);
            min = 1;
            countMap.putIfAbsent(1, new DoubleList());
            countMap.get(1).addFirst(node);
            nodeMap.put(key, node);
            size++;
        }
    }

    class DoubleList {
        Node head;
        Node tail;
        int size;

        public DoubleList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
            size++;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        int removeLast() {
            Node node = tail.pre;
            node.pre.next = tail;
            tail.pre = node.pre;
            size--;
            return node.key;
        }
    }

    class Node {
        int key;
        int val;
        int count;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }
}
