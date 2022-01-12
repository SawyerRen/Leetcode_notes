package company.ffff;


public class Q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node copy = head.next, copyHead = head.next;
        while (copy.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        cur.next = cur.next.next;
        return copyHead;
    }
}
