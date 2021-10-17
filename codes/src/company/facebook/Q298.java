package company.facebook;

import model.TreeNode;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, root.val - 1, 0);
        return res;
    }

    private void helper(TreeNode root, int val, int len) {
        if (root == null) return;
        if (val == root.val - 1) {
            len += 1;
        } else {
            len = 1;
        }
        res = Math.max(res, len);
        helper(root.left, root.val, len);
        helper(root.right, root.val, len);
    }
}
