package ng2022.q600;

import model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        queue.add(root);
        colQueue.add(1);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer small = null, large = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                Integer col = colQueue.poll();
                small = small == null ? col : small;
                large = col;
                if (poll.left != null) {
                    queue.add(poll.left);
                    colQueue.add(col * 2);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    colQueue.add(col * 2 + 1);
                }
            }
            res = Math.max(res, large - small + 1);
        }
        return res;
    }
}
