package company.ffff;

import model.TreeNode;

import java.util.Stack;

public class Q173 {
    class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            buildStack(root);
        }

        private void buildStack(TreeNode node) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            buildStack(node.right);
            return node.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
