package company.fbr4.p100;

import model.TreeNode;

public class Q124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        res = Math.max(left + right + root.val, res);
        return Math.max(left, right) + root.val;
    }
}
