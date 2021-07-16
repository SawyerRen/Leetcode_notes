package topics.tree;

import model.TreeNode;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (root.left != null && root.val != root.left.val - 1) {
            left = 1;
        }
        if (root.right != null && root.val != root.right.val - 1) {
            right = 1;
        }
        int curMax = Math.max(left, right);
        res = Math.max(res, curMax);
        return curMax;
    }
}
