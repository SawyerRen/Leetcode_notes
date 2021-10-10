package company.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node();
        prev = dummy;
        helper(root);
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        helper(root.right);
    }

    public Node treeToDoublyList1(Node root) {
        if (root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        List<Node> list = new ArrayList<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node node = stack.pop();
            list.add(node);
            cur = node.right;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        list.get(0).left = list.get(list.size() - 1);
        list.get(list.size() - 1).right = list.get(0);
        return list.get(0);
    }
}
