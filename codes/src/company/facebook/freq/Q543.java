package company.facebook.freq;

import model.TreeNode;

import java.util.Map;

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
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
