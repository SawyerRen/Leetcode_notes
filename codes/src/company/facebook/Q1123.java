package company.facebook;

import model.TreeNode;

import java.util.Map;

public class Q1123 {
    int maxDepth = 0;
    TreeNode res = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private int helper(TreeNode root, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (root == null) return depth;
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (left == maxDepth && right == maxDepth) {
            res = root;
        }
        return Math.max(left, right);
    }
}
