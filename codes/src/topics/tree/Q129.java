package topics.tree;

import model.TreeNode;

public class Q129 {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int val) {
        if (root == null) return;
        int sum = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += sum;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
