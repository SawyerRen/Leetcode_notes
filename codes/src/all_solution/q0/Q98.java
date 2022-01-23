package all_solution.q0;

import model.TreeNode;

public class Q98 {
    boolean res = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return res;
        helper(root, null, null);
        return res;
    }

    private void helper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return;
        if (minNode != null && root.val <= minNode.val) {
            res = false;
            return;
        }
        if (maxNode != null && root.val >= maxNode.val) {
            res = false;
            return;
        }
        helper(root.left, minNode, root);
        helper(root.right, root, maxNode);
    }
}
