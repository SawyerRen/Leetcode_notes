package company.facebook;

public class Q155 {
}

class MinStack {
    class Node {
        int min;
        int val;
        Node next;

        public Node(int min, int val, Node next) {
            this.min = min;
            this.val = val;
            this.next = next;
        }
    }

    Node head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) head = new Node(val, val, null);
        else head = new Node(Math.min(val, head.min), val, head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}