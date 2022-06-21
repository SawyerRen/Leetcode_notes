package all_solution.q0;

import model.TreeNode;

public class Q98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if (root == null) return true;
        if (minNode != null && minNode.val >= root.val) return false;
        if (maxNode != null && maxNode.val <= root.val) return false;
        return helper(root.left, minNode, root) && helper(root.right, root, maxNode);
    }
}
