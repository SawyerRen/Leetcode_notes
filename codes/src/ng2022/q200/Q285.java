package ng2022.q200;

import model.TreeNode;

public class Q285 {
    TreeNode target = null, res = null;

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        helper(root, p);
        return res;
    }

    private void helper(TreeNode root, TreeNode p) {
        if (root == null) return;
        helper(root.left, p);
        if (target != null) {
            res = res == null ? root : res;
            return;
        }
        if (root.val == p.val) {
            target = root;
        }
        helper(root.right, p);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
