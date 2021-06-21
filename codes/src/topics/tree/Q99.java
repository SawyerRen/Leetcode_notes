package topics.tree;

import model.TreeNode;

public class Q99 {
    TreeNode n1, n2, pre;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null && pre.val > root.val) {
            n1 = n1 == null ? pre : n1;
            n2 = root;
        }
        pre = root;
        helper(root.right);
    }
}
