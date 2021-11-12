package company.fbr5.q400;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class Q460 {
    class LFUCache {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, DoubleList> countMap = new HashMap<>();
        int min = 0, size = 0, capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!nodeMap.containsKey(key)) return -1;
            Node node = nodeMap.get(key);
            update(node);
            return node.val;
        }

        private void update(Node node) {
            int oldCount = node.count;
            countMap.get(oldCount).remove(node);
            if (countMap.get(oldCount).size == 0 && oldCount == min) min++;
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
                    DoubleList minList = countMap.get(min);
                    int lastKey = minList.removeLast();
                    if (minList.size == 0) min++;
                    nodeMap.remove(lastKey);
                    size--;
                }
                Node node = new Node(key, value, 1);
                min = 1;
                nodeMap.put(key, node);
                countMap.putIfAbsent(min, new DoubleList());
                countMap.get(1).addFirst(node);
                size++;
            }
        }
    }

    class DoubleList {
        Node head;
        Node tail;
        int size = 0;

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
            node.pre = head;
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

        public Node(int key, int val, int count) {
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }
}
