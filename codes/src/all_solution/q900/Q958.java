package all_solution.q900;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q958 {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                flag = true;
            } else {
                if (flag) return false;
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return true;
    }
}
