package company.fbr5.q800;

import model.TreeNode;

public class Q897 {
    TreeNode head;
    TreeNode tail;

    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return head;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (tail != null) {
            tail.right = root;
            root.left = null;
        } else {
            head = root;
        }
        tail = root;
        helper(root.right);
    }
}
