package topics.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
}

class LRUCache {
    Map<Integer, DoubleNode> map;
    DoubleLinkedList cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleLinkedList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        DoubleNode node = new DoubleNode(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        } else {
            if (cache.size == capacity) {
                int lastKey = cache.removeLast();
                map.remove(lastKey);
            }
        }
        cache.addFirst(node);
        map.put(key, node);
    }
}

class DoubleLinkedList {
    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleLinkedList() {
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void addFirst(DoubleNode node) {
        DoubleNode next = head.next;
        next.pre = node;
        node.next = next;
        head.next = node;
        node.pre = head;
        size++;
    }

    public void remove(DoubleNode node) {
        DoubleNode pre = node.pre;
        DoubleNode next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    public int removeLast() {
        DoubleNode last = tail.pre;
        DoubleNode pre = last.pre;
        pre.next = tail;
        tail.pre = pre;
        size--;
        return last.key;
    }
}

class DoubleNode {
    int key;
    int val;
    DoubleNode pre;
    DoubleNode next;

    public DoubleNode() {
    }

    public DoubleNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}