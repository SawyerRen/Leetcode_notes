package company.fbfinal;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
    class LRUCache {
        Map<Integer, Node> map = new HashMap<>();
        DList list = new DList();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            put(key, node.val);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (map.containsKey(key)) {
                list.remove(map.get(key));
                map.remove(key);
            } else {
                if (capacity == list.size) {
                    int lastKey = list.removeLast();
                    map.remove(lastKey);
                }
            }
            map.put(key, node);
            list.addFirst(node);
        }
    }

    class DList {
        Node head;
        Node tail;
        int size = 0;

        public DList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
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
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
