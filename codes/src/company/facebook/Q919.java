package company.facebook;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q919 {
}

class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode peek = queue.peek();
            if (peek.left != null && peek.right != null) {
                queue.add(peek.left);
                queue.add(peek.right);
                queue.poll();
            } else {
                break;
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode peek = queue.peek();
        if (peek.left == null) {
            peek.left = node;
        } else {
            peek.right = node;
            queue.add(peek.left);
            queue.add(peek.right);
            queue.poll();
        }
        return peek.val;
    }

    public TreeNode get_root() {
        return root;
    }
}