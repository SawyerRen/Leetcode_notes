package topics.tree;

import model.TreeNode;

import java.util.LinkedList;

public class Q173 {
}

class BSTIterator {
    LinkedList<TreeNode> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        list.add(root);
        helper(root.right);
    }

    public int next() {
        return list.removeFirst().val;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}