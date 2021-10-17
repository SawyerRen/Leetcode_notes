package company.facebook;

import model.TreeNode;

public class Q1026 {
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val, root.val);
        return res;
    }

    private void helper(TreeNode root, int min, int max) {
        if (root == null) return;
        if (root.val > max) {
            max = root.val;
            res = Math.max(res, max - min);
        } else if (root.val < min) {
            min = root.val;
            res = Math.max(res, max - min);
        }
        helper(root.left, min, max);
        helper(root.right, min, max);
    }
}
