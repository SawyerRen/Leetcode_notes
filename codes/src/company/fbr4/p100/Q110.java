package company.fbr4.p100;

import model.TreeNode;

public class Q110 {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left, right) + 1;
    }
}
