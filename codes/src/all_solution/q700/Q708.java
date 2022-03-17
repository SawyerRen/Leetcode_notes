package all_solution.q700;

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
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node maxNode = head, minNode;
        while (maxNode.next != head && maxNode.next.val >= maxNode.val) {
            maxNode = maxNode.next;
        }
        minNode = maxNode.next;
        Node node = new Node(insertVal);
        if (insertVal >= maxNode.val || insertVal <= minNode.val) {
            maxNode.next = node;
            node.next = minNode;
        } else {
            while (insertVal >= minNode.next.val) {
                minNode = minNode.next;
            }
            node.next = minNode.next;
            minNode.next = node;
        }
        return head;
    }
}
