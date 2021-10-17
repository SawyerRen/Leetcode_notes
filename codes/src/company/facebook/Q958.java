package company.facebook;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) end = true;
            else {
                if (end) return false;
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return true;
    }
}
