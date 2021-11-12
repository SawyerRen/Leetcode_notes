package company.fbr4.p100;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root, int depth) {
        if (root == null) return;
        if (depth == res.size()) res.add(root.val);
        helper(res, root.right, depth + 1);
        helper(res, root.left, depth + 1);
    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.right != null) queue.add(poll.right);
                if (poll.left != null) queue.add(poll.left);
            }
        }
        return res;
    }
}
