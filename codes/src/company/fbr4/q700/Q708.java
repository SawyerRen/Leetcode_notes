package company.fbr4.q700;

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
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node maxNode = head;
        while (maxNode.next != head && maxNode.next.val >= maxNode.val) {
            maxNode = maxNode.next;
        }
        Node minNode = maxNode.next;
        if (insertVal >= maxNode.val || insertVal <= minNode.val) {
            maxNode.next = node;
            node.next = minNode;
        } else {
            while (minNode.next.val <= insertVal) {
                minNode = minNode.next;
            }
            node.next = minNode.next;
            minNode.next = node;
        }
        return head;
    }
}
