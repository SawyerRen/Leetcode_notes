package company.fbfinal;

import java.util.Stack;
import java.util.TreeMap;

public class Q426 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList1(Node root) {
        if (root == null) return null;
        Node dummy = new Node();
        Node pre = dummy;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
            cur = cur.right;
        }
        dummy.right.left = pre;
        pre.right = dummy.right;
        return dummy.right;
    }

    Node head;
    Node tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        if (tail != null) {
            tail.right = root;
            root.left = tail;
        } else {
            head = root;
        }
        tail = root;
        helper(root.right);
    }
}
