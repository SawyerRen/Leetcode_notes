package topics.design;

import java.util.HashMap;
import java.util.Map;

public class Q460 {
}

class LFUCache {
    class DoubleNode {
        int key;
        int val;
        int count;
        DoubleNode pre;
        DoubleNode next;

        public DoubleNode(int key, int val) {
            this.key = key;
            this.val = val;
            count = 1;
        }
    }

    class DoubleList {
        DoubleNode head;
        DoubleNode tail;
        int size;

        public DoubleList() {
            head = new DoubleNode(0, 0);
            tail = new DoubleNode(0, 0);
            size = 0;
            head.next = tail;
            tail.pre = head;
        }

        void addToHead(DoubleNode node) {
            DoubleNode next = head.next;
            head.next = node;
            node.pre = head;
            node.next = next;
            next.pre = node;
            size++;
        }

        void remove(DoubleNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        DoubleNode removeLast() {
            DoubleNode node = tail.pre;
            node.pre.next = tail;
            tail.pre = node.pre;
            size--;
            return node;
        }
    }

    int min, capacity;
    Map<Integer, DoubleNode> nodeMap;
    Map<Integer, DoubleList> countMap;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        DoubleNode node = nodeMap.get(key);
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (nodeMap.containsKey(key)) {
            DoubleNode node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            DoubleNode node = new DoubleNode(key, value);
            if (nodeMap.size() == capacity) {
                DoubleNode last = countMap.get(min).removeLast();
                nodeMap.remove(last.key);
            }
            nodeMap.put(key, node);
            min = 1;
            DoubleList list = countMap.getOrDefault(node.count, new DoubleList());
            list.addToHead(node);
            countMap.put(node.count, list);
        }
    }

    private void update(DoubleNode node) {
        DoubleList list = countMap.get(node.count);
        list.remove(node);
        if (node.count == min && list.size == 0) min++;
        node.count++;
        DoubleList newList = countMap.getOrDefault(node.count, new DoubleList());
        newList.addToHead(node);
        countMap.put(node.count, newList);
    }
}