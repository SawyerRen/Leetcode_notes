package company.facebook;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.add(root);
        int max = Integer.MIN_VALUE;
        int level = 0, res = 0;
        while (!queue.isEmpty()) {
            level++;
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (sum > max) {
                max = sum;
                res = level;
            }
        }
        return res;
    }
}
