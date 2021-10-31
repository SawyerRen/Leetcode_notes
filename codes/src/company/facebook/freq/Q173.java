package company.facebook.freq;

import com.sun.source.tree.Tree;
import model.TreeNode;

import java.util.Stack;

public class Q173 {
    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            buildStack(root);
        }

        void buildStack(TreeNode cur) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
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
