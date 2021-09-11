package all_solution.q100;

import java.util.LinkedList;
import java.util.Queue;

public class Q117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    if (poll.right != null) {
                        poll.left.next = poll.right;
                    } else {
                        poll.left.next = getNext(poll.next);
                    }
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.next = getNext(poll.next);
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }

    private Node getNext(Node next) {
        if (next == null) return null;
        while (next != null) {
            if (next.left != null) return next.left;
            if (next.right != null) return next.right;
            next = next.next;
        }
        return null;
    }
}
