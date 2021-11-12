package company.fb2;

import model.TreeNode;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, root.val - 1, 0);
        return res;
    }

    private void helper(TreeNode root, int pre, int depth) {
        if (root == null) return;
        if (root.val == pre + 1) {
            depth++;
        } else {
            depth = 1;
        }
        res = Math.max(depth, res);
        helper(root.left, root.val, depth);
        helper(root.right, root.val, depth);
    }
}
