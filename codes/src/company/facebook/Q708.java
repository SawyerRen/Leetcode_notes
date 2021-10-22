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
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node maxNode = head;
        while (maxNode.next.val >= maxNode.val && maxNode.next != head) {
            maxNode = maxNode.next;
        }
        Node minNode = maxNode.next;
        if (insertVal <= minNode.val || insertVal >= maxNode.val) {
            maxNode.next = node;
            node.next = minNode;
        } else {
            Node cur = minNode;
            while (cur.next != null && insertVal > cur.next.val) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
        return head;
    }
}
