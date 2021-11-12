package company.fbr5.q200;

import model.TreeNode;

import java.util.Map;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, root.val - 1, 0);
        return res;
    }

    private void helper(TreeNode root, int pre, int len) {
        if (root == null) return;
        if (root.val == pre + 1) {
            len++;
        } else {
            len = 1;
        }
        res = Math.max(res, len);
        helper(root.left, root.val, len);
        helper(root.right, root.val, len);
    }
}
