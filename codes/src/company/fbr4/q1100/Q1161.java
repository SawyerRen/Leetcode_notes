package company.fbr4.q1100;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = -1, max = Integer.MIN_VALUE, row = 1;
        while (!queue.isEmpty()) {
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
                res = row;
            }
            row++;
        }
        return res;
    }
}
