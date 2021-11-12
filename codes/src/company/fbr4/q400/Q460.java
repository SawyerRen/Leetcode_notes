package company.fbr4.q400;

import java.util.HashMap;
import java.util.Map;

public class Q460 {
    class LFUCache {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, DoubleList> countMap = new HashMap<>();
        int min, capacity, size;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            min = 0;
            size = 0;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) return -1;
            Node node = nodeMap.get(key);
            update(node);
            return node.val;
        }

        private void update(Node node) {
            int oldCount = node.count;
            DoubleList oldList = countMap.get(oldCount);
            oldList.remove(node);
            if (oldList.size == 0 && oldCount == min) min++;
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
                if (capacity == size) {
                    DoubleList minList = countMap.get(min);
                    int lastKey = minList.removeLast();
                    nodeMap.remove(lastKey);
                    size--;
                }
                Node node = new Node(key, value);
                min = 1;
                size++;
                countMap.putIfAbsent(min, new DoubleList());
                countMap.get(min).addFirst(node);
                nodeMap.put(key, node);
            }
        }
    }

    class DoubleList {
        Node head;
        Node tail;
        int size;

        public DoubleList() {
            size = 0;
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
        int count;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            count = 1;
        }
    }
}
