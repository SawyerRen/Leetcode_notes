package all_solution.q200;

import model.TreeNode;

public class Q129 {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int preVal) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res += preVal * 10 + root.val;
            return;
        }
        helper(root.left, preVal * 10 + root.val);
        helper(root.right, preVal * 10 + root.val);
    }
}
