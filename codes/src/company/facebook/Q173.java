package company.facebook;

import model.TreeNode;

import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Q173 {
}

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode cur = node.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}