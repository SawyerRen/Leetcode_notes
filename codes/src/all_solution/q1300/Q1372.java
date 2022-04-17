package all_solution.q1300;

import model.TreeNode;

public class Q1372 {
    int res = 0;

    public int longestZigZag(TreeNode root) {
        helper(root, -1, 0);
        helper(root, 1, 0);
        return res;
    }

    private void helper(TreeNode root, int dir, int len) {
        if (root == null) return;
        res = Math.max(res, len);
        if (dir == -1) {
            helper(root.left, 1, len + 1);
            helper(root.right, -1, 1);
        } else {
            helper(root.right, -1, len + 1);
            helper(root.left, 1, 1);
        }
    }
}
