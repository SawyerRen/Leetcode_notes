package company.fbr5.q100;

import model.TreeNode;

public class Q114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        while (root != null) {
            if (root.left != null) {
                TreeNode last = root.left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flatten1(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = right;
    }
}
