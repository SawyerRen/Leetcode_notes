package all_solution.q100;

import model.TreeNode;

import java.util.Map;

public class Q110 {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left, right) + 1;
    }
}
