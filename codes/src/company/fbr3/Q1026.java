package company.fbr3;

import model.TreeNode;

public class Q1026 {
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return res;
    }

    private void helper(TreeNode root, int min, int max) {
        if (root == null) return;
        int diff1 = Math.abs(root.val - min);
        int diff2 = Math.abs(root.val - max);
        res = Math.max(res, Math.max(diff1, diff2));
        min = Math.min(root.val, min);
        max = Math.max(root.val, max);
        helper(root.left, min, max);
        helper(root.right, min, max);
    }
}
