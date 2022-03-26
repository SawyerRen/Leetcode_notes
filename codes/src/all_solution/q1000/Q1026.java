package all_solution.q1000;

import model.TreeNode;

public class Q1026 {
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return res;
    }

    private void helper(TreeNode root, int minVal, int maxVal) {
        if (root == null) return;
        res = Math.max(res, Math.max(Math.abs(root.val - minVal), Math.abs(root.val - maxVal)));
        helper(root.left, Math.min(minVal, root.val), Math.max(maxVal, root.val));
        helper(root.right, Math.min(minVal, root.val), Math.max(maxVal, root.val));
    }
}
