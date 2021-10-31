package company.facebook.freq;

import model.TreeNode;

public class Q129 {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += sum;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
