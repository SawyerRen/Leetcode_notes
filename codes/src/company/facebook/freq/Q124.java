package company.facebook.freq;

import model.TreeNode;

import java.util.Map;

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
        int sum = left + right + root.val;
        res = Math.max(res, sum);
        return Math.max(left, right) + root.val;
    }
}
