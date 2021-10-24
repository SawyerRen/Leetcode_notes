package company.facebook;

public class Q708 {
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node maxNode = head;
        while (maxNode.next != head && maxNode.next.val >= maxNode.val) {
            maxNode = maxNode.next;
        }
        Node minNode = maxNode.next;
        if (minNode.val >= insertVal || maxNode.val <= insertVal) {
            maxNode.next = newNode;
            newNode.next = minNode;
        } else {
            Node cur = minNode;
            while (cur.next.val < insertVal) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        return head;
    }
}
