package frequency.q100;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
}

class LRUCache {
    Map<Integer, LRUNode> map = new HashMap<>();
    LRUList list = new LRUList();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        LRUNode node = map.get(key);
        put(key, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        LRUNode node = new LRUNode(key, value);
        if (!map.containsKey(key)) {
            if (list.size == this.capacity) {
                int lastKey = list.removeLast();
                map.remove(lastKey);
            }
        } else {
            list.remove(map.get(key));
            map.remove(key);
        }
        list.addFirst(node);
        map.put(key, node);
    }
}

class LRUList {
    LRUNode head;
    LRUNode tail;
    int size;

    public LRUList() {
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    void addFirst(LRUNode node) {
        LRUNode next = head.next;
        node.next = next;
        next.pre = node;
        head.next = node;
        node.pre = head;
        size++;
    }

    void remove(LRUNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    int removeLast() {
        LRUNode last = tail.pre;
        last.pre.next = tail;
        tail.pre = last.pre;
        size--;
        return last.key;
    }
}

class LRUNode {
    int key;
    int val;
    LRUNode pre;
    LRUNode next;

    public LRUNode() {
    }

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}