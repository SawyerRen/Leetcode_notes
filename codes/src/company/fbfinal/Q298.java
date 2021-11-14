package company.fbfinal;

import model.TreeNode;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val - 1, 0);
        return res;
    }

    private void helper(TreeNode root, int pre, int len) {
        if (root == null) return;
        if (root.val == pre + 1) {
            len++;
            res = Math.max(res, len);
        } else {
            len = 1;
        }
        helper(root.left, root.val, len);
        helper(root.right, root.val, len);
    }
}
