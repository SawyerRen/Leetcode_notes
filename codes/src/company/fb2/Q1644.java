package company.fb2;

import model.TreeNode;

public class Q1644 {
    int count = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = helper(root, p, q);
        if (count == 2) return res;
        return null;
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (root == p || root == q) {
            count++;
            return root;
        }
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}
