package all_solution.q100;

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
        if (map.containsKey(key)) {
            LRUNode node1 = map.get(key);
            list.remove(node1);
            map.remove(key);
        } else {
            if (this.capacity == list.size) {
                int lastKey = list.removeLast();
                map.remove(lastKey);
            }
        }
        map.put(key, node);
        list.addFirst(node);
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
        node.next = head.next;
        node.next.pre = node;
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