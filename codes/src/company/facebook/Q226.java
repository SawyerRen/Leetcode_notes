package company.facebook;

import model.TreeNode;

public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
