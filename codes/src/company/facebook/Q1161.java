package company.facebook;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (max < sum) {
                max = sum;
                res = level;
            }
            level++;
        }
        return res;
    }
}
