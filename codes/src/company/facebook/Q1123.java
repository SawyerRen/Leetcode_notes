package company.facebook;

import model.TreeNode;

public class Q1123 {
    TreeNode res = null;
    int deepest = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private int helper(TreeNode root, int depth) {
        deepest = Math.max(deepest, depth);
        if (root == null) return depth;
        int left = helper(root.left, depth + 1);
        int right = helper(root.right, depth + 1);
        if (left == deepest && right == deepest) {
            res = root;
        }
        return Math.max(left, right);
    }
}
