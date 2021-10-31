package company.fbr3;

import model.TreeNode;

import java.util.Stack;

public class Q173 {
}

class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        buildStack(root);
    }

    private void buildStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        if (pop.right != null) buildStack(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}