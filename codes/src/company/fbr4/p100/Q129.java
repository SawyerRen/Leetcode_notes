package company.fbr4.p100;

import model.TreeNode;

public class Q129 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
    }
}
