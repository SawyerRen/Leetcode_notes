package company.fb2;

import model.TreeNode;

import java.util.Stack;

public class Q173 {
    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            buildStack(root);
        }

        private void buildStack(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = stack.pop();
            int res = node.val;
            buildStack(node.right);
            return res;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
