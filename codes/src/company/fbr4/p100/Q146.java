package company.fbr4.p100;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        Map<Integer, Node> map;
        DoubleList doubleList;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            doubleList = new DoubleList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            put(node.key, node.val);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                doubleList.remove(map.get(key));
                map.remove(key);
            } else {
                if (capacity == doubleList.size) {
                    int lastKey = doubleList.removeLast();
                    map.remove(lastKey);
                }
            }
            map.put(key, node);
            doubleList.addFirst(node);
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
            node.pre = head;
            node.next.pre = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        int removeLast() {
            Node last = tail.pre;
            last.pre.next = tail;
            tail.pre = last.pre;
            size--;
            return last.key;
        }
    }

    class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
