package company.facebook;

import model.TreeNode;

public class Q543 {
    int sum = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return sum;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        sum = Math.max(sum, left + right);
        return Math.max(left, right) + 1;
    }
}
