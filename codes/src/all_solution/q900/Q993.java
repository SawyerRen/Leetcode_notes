package all_solution.q900;

import model.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode parent = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    if (poll.left.val == x || poll.left.val == y) {
                        if (parent != null && parent != poll) return true;
                        parent = poll;
                    }
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    if (poll.right.val == x || poll.right.val == y) {
                        if (parent != null && parent != poll) return true;
                        parent = poll;
                    }
                    queue.add(poll.right);
                }
            }
            parent = null;
        }
        return false;
    }
}
