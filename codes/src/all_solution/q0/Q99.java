package all_solution.q0;

import model.TreeNode;

public class Q99 {
    TreeNode node1 = null, node2 = null, preNode = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (preNode != null && root.val < preNode.val) {
            node1 = node1 == null ? preNode : node1;
            node2 = root;
        }
        preNode = root;
        helper(root.right);
    }
}
