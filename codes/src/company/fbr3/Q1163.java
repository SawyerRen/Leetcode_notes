package company.fbr3;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q1163 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int level = 0;
        int maxLevel = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}
