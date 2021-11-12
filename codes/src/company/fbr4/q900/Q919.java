package company.fbr4.q900;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q919 {
    class CBTInserter {
        Queue<TreeNode> queue;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode peek = queue.peek();
                if (peek.left == null || peek.right == null) break;
                queue.poll();
                queue.add(peek.left);
                queue.add(peek.right);
            }
        }

        public int insert(int val) {
            TreeNode peek = queue.peek();
            if (peek.left == null) {
                peek.left = new TreeNode(val);
            } else {
                peek.right = new TreeNode(val);
                queue.poll();
                queue.add(peek.left);
                queue.add(peek.right);
            }
            return peek.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
