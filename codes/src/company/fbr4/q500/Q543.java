package company.fbr4.q500;

import model.TreeNode;

public class Q543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }
}
