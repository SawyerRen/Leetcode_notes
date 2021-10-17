package company.facebook;

import model.TreeNode;

public class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        return root;
    }
}
