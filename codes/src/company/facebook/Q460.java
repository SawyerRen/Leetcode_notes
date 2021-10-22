package company.facebook;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Q460 {
}

class LFUCache {
    Map<Integer, LFUNode> nodeMap = new HashMap<>();
    Map<Integer, LFUList> countMap = new HashMap<>();
    int capacity;
    int min, size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        LFUNode node = nodeMap.get(key);
        update(node);
        return node.val;
    }

    private void update(LFUNode node) {
        LFUList list = countMap.get(node.count);
        list.remove(node);
        if (node.count == min && list.size == 0) min++;
        node.count++;
        LFUList newList = countMap.getOrDefault(node.count, new LFUList());
        newList.addFirst(node);
        countMap.put(node.count, newList);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        LFUNode node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            node = new LFUNode(key, value, 1);
            if (size == capacity) {
                LFUList minList = countMap.get(min);
                int lastKey = minList.removeLast();
                nodeMap.remove(lastKey);
                size--;
            }
            size++;
            min = 1;
            LFUList list = countMap.getOrDefault(1, new LFUList());
            list.addFirst(node);
            countMap.put(1, list);
            nodeMap.put(key, node);
        }
    }
}

class LFUList {
    LFUNode head;
    LFUNode tail;
    int size;

    public LFUList() {
        head = new LFUNode();
        tail = new LFUNode();
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    void addFirst(LFUNode node) {
        LFUNode next = head.next;
        node.next = next;
        node.pre = head;
        head.next = node;
        next.pre = node;
        size++;
    }

    void remove(LFUNode node) {
        LFUNode pre = node.pre;
        LFUNode next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    Integer removeLast() {
        if (size == 0) return null;
        LFUNode node = tail.pre;
        LFUNode pre = node.pre;
        pre.next = tail;
        tail.pre = pre;
        size--;
        return node.key;
    }
}

class LFUNode {
    int key;
    int val;
    int count;
    LFUNode pre;
    LFUNode next;

    public LFUNode() {
    }

    public LFUNode(int key, int val, int count) {
        this.key = key;
        this.val = val;
        this.count = count;
    }
}
