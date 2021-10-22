package company.facebook;

import model.TreeNode;

public class Q1026 {
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return res;
    }

    private void helper(TreeNode root, int min, int max) {
        if (root == null) return;
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        res = Math.max(res, Math.max(max - root.val, root.val - min));
        helper(root.left, min, max);
        helper(root.right, min, max);
    }
}
