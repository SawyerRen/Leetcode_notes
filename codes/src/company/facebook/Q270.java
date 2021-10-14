package company.facebook;

import model.TreeNode;

public class Q270 {
    int res;
    double minDiff = Integer.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        res = root.val;
        helper(root, target);
        return res;
    }

    private void helper(TreeNode root, double target) {
        if (root == null) return;
        if (root.val == target) {
            minDiff = 0;
            res = root.val;
            return;
        }
        if (root.val < target) {
            if (minDiff > target - root.val) {
                minDiff = target - root.val;
                res = root.val;
            }
            helper(root.right, target);
        }
        if (root.val > target) {
            if (minDiff > root.val - target) {
                minDiff = root.val - target;
                res = root.val;
            }
            helper(root.left, target);
        }
    }
}
