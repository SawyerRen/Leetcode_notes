package company.facebook;

import model.TreeNode;

import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class Q173 {
}

class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    public int next() {
        TreeNode cur = stack.pop();
        int next = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return next;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}