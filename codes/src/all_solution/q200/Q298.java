package all_solution.q200;

import model.TreeNode;

public class Q298 {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root, 0, root.val);
        return res;
    }

    private void helper(TreeNode root, int cur, int target) {
        if (root == null) return;
        if (root.val == target) cur++;
        else cur = 1;
        res = Math.max(cur, res);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}
