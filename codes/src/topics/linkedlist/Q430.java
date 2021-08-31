package topics.linkedlist;

import java.util.Stack;

public class Q430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                stack.push(cur.next);
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            while (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                if (cur.next != null) cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
