package company.fbr3;

import model.TreeNode;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, root.val - 1, 0);
        return res;
    }

    private void helper(TreeNode root, int pre, int length) {
        if (root == null) return;
        if (root.val == pre + 1) {
            length++;
            res = Math.max(res, length);
        } else {
            length = 1;
        }
        helper(root.left, root.val, length);
        helper(root.right, root.val, length);
    }
}
