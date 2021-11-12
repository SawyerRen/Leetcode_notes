package company.fbr4.q200;

import model.TreeNode;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, 0, root.val - 1);
        return res;
    }

    private void helper(TreeNode root, int len, int pre) {
        if (root == null) return;
        if (root.val == pre + 1) {
            len++;
            res = Math.max(res, len);
        } else {
            len = 1;
        }
        helper(root.left, len, root.val);
        helper(root.right, len, root.val);
    }
}
