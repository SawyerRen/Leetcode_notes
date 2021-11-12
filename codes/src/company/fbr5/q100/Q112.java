package company.fbr5.q100;

import model.TreeNode;

public class Q112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    private boolean helper(TreeNode root, int target, int sum) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == target;
        }
        if (helper(root.left, target, sum) || helper(root.right, target, sum)) return true;
        return false;
    }
}
