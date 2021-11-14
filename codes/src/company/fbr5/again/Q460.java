package company.fbr5.again;

import java.util.HashMap;
import java.util.Map;

public class Q460 {
    class LFUCache {
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, DoubleList> countMap = new HashMap<>();
        int min, size, capacity;

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
            if (oldList.size == 0 && min == oldCount) min++;
            node.count++;
            countMap.putIfAbsent(node.count, new DoubleList());
            countMap.get(node.count).addFirst(node);
            nodeMap.put(node.key, node);
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (nodeMap.containsKey(key)) {
                Node node = nodeMap.get(key);
                node.val = value;
                update(node);
            } else {
                Node node = new Node(key, value, 1);
                if (size == capacity) {
                    DoubleList minList = countMap.get(min);
                    int lastKey = minList.removeLast();
                    nodeMap.remove(lastKey);
                    size--;
                }
                min = 1;
                nodeMap.put(key, node);
                size++;
                countMap.putIfAbsent(1, new DoubleList());
                countMap.get(1).addFirst(node);
            }
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
