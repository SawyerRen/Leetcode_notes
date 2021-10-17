package company.facebook;

import model.TreeNode;

// 不用global variable怎么办？
public class Q129 {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int val) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res += val * 10 + root.val;
            return;
        }
        val = val * 10 + root.val;
        helper(root.left, val);
        helper(root.right, val);
    }
}
