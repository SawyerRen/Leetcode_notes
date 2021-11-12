package company.fbr5.q800;

import model.TreeNode;

import java.util.Map;

public class Q865 {
    int maxDepth = 0;
    TreeNode res = null;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private int helper(TreeNode root, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (root == null) return depth;
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (left == maxDepth && right == maxDepth) res = root;
        return Math.max(left, right);
    }
}
