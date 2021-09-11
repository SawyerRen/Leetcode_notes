package all_solution.q100;

import model.TreeNode;

import java.util.Map;

public class Q110 {
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        helper(root);
        return balanced;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1) balanced = false;
        return Math.max(left, right) + 1;
    }
}
