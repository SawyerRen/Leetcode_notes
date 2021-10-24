package company.facebook;

import model.TreeNode;

// 不用global variable怎么办？
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
        int left = helper(root.left, sum);
        int right = helper(root.right, sum);
        return left + right;
    }
}
