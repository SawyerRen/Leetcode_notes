package topics.tree;

import model.TreeNode;

public class Q124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        if (root.val + left + right > res) {
            res = root.val + left + right;
        }
        return Math.max(left, right) + root.val;
    }
}
