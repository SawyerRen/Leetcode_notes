package company.fbr4.again;

import model.TreeNode;

public class Q538 {
    int pre = 0;

    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        pre += root.val;
        root.val = pre;
        helper(root.left);
    }
}
