package company.fbr3;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) break;
            queue.add(poll.left);
            queue.add(poll.right);
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) return false;
        }
        return true;
    }
}
