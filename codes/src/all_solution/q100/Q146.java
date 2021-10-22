package all_solution.q100;

import java.util.HashMap;
import java.util.Map;

public class Q146 {
}

class LRUCache {
    DoubleLinkedList cache;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        cache = new DoubleLinkedList();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        put(node.key, node.value);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            map.remove(key);
        } else {
            if (cache.size == capacity) {
                int last = cache.removeLast();
                map.remove(last);
            }
        }
        map.put(key, node);
        cache.addFirst(node);
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    int size;

    public DoubleLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    void addFirst(Node node) {
        Node next = head.next;
        node.next = next;
        node.pre = head;
        head.next = node;
        next.pre = node;
        size++;
    }

    void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    int removeLast() {
        Node node = tail.pre;
        Node pre = node.pre;
        pre.next = tail;
        tail.pre = pre;
        size--;
        return node.key;
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node pre;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}