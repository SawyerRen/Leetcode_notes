package all_solution.q100;

import model.TreeNode;

public class Q98 {
    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        helper(root, null, null);
        return valid;
    }

    private void helper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return;
        if (minNode != null && root.val <= minNode.val) {
            valid = false;
            return;
        }
        if (maxNode != null && root.val >= maxNode.val) {
            valid = false;
            return;
        }
        helper(root.left, minNode, root);
        helper(root.right, root, maxNode);
    }
}
