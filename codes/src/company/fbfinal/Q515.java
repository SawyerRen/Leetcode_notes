package company.fbfinal;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q515 {
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() == depth) res.add(root.val);
        else {
            res.set(depth, Math.max(root.val, res.get(depth)));
        }
        helper(res, root.left, depth + 1);
        helper(res, root.right, depth + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                max = Math.max(poll.val, max);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(max);
        }
        return res;
    }
}
