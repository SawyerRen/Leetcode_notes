package company.fbfinal;

import model.TreeNode;

import java.util.Stack;

public class Q173 {
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
            if (!hasNext()) return -1;
            TreeNode cur = stack.pop();
            buildStack(cur.right);
            return cur.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
