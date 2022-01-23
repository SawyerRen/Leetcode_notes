package all_solution.q0;

import model.TreeNode;

public class Q99 {
    TreeNode n1 = null, n2 = null, pre = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int t = n1.val;
        n1.val = n2.val;
        n2.val = t;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (pre != null) {
            if (root.val < pre.val) {
                if (n1 == null) n1 = pre;
                n2 = root;
            }
        }
        pre = root;
        helper(root.right);
    }
}
