package company.fbr4.p100;

import model.TreeNode;

public class Q112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, 0, targetSum);
    }

    private boolean helper(TreeNode root, int sum, int target) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == target;
        }
        return helper(root.left, sum, target) || helper(root.right, sum, target);
    }
}
