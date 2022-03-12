package all_solution.q400;

import java.util.HashMap;
import java.util.Map;

public class Q460 {
}

class LFUCache {
    Map<Integer, Node> nodeMap;
    Map<Integer, DoubleLinkedList> countMap;
    int min, size, capacity;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
        min = 0;
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.val;
    }

    private void update(Node node) {
        DoubleLinkedList list = countMap.get(node.count);
        list.remove(node);
        if (node.count == min && list.size == 0) min++;
        node.count++;
        countMap.putIfAbsent(node.count, new DoubleLinkedList());
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
                DoubleLinkedList list = countMap.get(min);
                int lastKey = list.removeLast();
                nodeMap.remove(lastKey);
                size--;
            }
            Node node = new Node(key, value);
            min = 1;
            countMap.putIfAbsent(1, new DoubleLinkedList());
            countMap.get(1).addFirst(node);
            nodeMap.put(key, node);
            size++;
        }
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
        Node last = tail.pre;
        tail.pre = last.pre;
        last.pre.next = tail;
        size--;
        return last.key;
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