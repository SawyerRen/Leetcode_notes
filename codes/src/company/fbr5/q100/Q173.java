package company.fbr5.q100;

import model.TreeNode;

import java.util.Stack;

public class Q173 {
    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            helper(root);
        }

        private void helper(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode pop = stack.pop();
            helper(pop.right);
            return pop.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
