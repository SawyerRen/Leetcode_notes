package company.facebook;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q919 {
}

class CBTInserter {
    Queue<TreeNode> queue;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        queue = new LinkedList<>();
        this.root = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.peek();
            if (peek.left == null || peek.right == null) break;
            TreeNode poll = queue.poll();
            queue.add(poll.left);
            queue.add(poll.right);
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