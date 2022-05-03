package all_solution.q1400;

import model.TreeNode;

public class Q1448 {
    int res = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return res;
    }

    private void helper(TreeNode root, int preVal) {
        if (root == null) return;
        if (root.val >= preVal) res++;
        helper(root.left, Math.max(preVal, root.val));
        helper(root.right, Math.max(preVal, root.val));
    }
}
