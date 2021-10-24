package company.facebook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Q146 {
}

class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    DoubleLinkedList list = new DoubleLinkedList();
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
                int last = list.removeLast();
                map.remove(last);
            }
        }
        map.put(key, node);
        list.addFirst(node);
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

    public void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.pre = head;
        node.next = next;
        next.pre = node;
        size++;
    }

    public void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        size--;
    }

    public int removeLast() {
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
    int val;
    Node pre;
    Node next;

    public Node() {
    }

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}